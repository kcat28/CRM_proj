/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.crm_project;

import java.awt.Component;
import java.awt.FontMetrics;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import javax.swing.Icon;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;

/**
 *
 * @author Jep
 */
public class backend_feedback {
    private dashboard dashboard;
    ArrayList<String> productFeedbacksArrayList = new ArrayList<>();
    
    
    public backend_feedback(dashboard dashboard){
    this.dashboard = dashboard;
}
    

    
    public void getTableF(){
        String url = "jdbc:mysql://localhost:3306/ibmcrm?zeroDateTimeBehavior=CONVERT_TO_NULL";
        String username = "root";
        String pass = "";
        
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(url, username, pass);
            
            String query = "SELECT * FROM feedback";
            Statement statement = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet resultSet = statement.executeQuery(query);
            
            DefaultTableModel model = (DefaultTableModel) dashboard.getFeedbackTable().getModel();
            model.setRowCount(0);
            
            while(resultSet.next()){
                Object[] rowData = {
                    resultSet.getInt("customer_id"), //ticket ID
                    resultSet.getInt("product_id"),
                    resultSet.getString("feedback_comment"),
                    resultSet.getString("feedback_rating"),
                    
                 
                };
                model.addRow(rowData);  
            }
            
        } catch(ClassNotFoundException | SQLException e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Failed to connect to database");
        }
        
        //ranking table
       try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conn = DriverManager.getConnection(url, username, pass);

        String query = "SELECT p.product_name, " +
                       "SUM(CASE WHEN f.feedback_rating = 1 THEN 1 ELSE 0 END) AS count_disatisfied, " +
                       "SUM(CASE WHEN f.feedback_rating = 2 THEN 1 ELSE 0 END) AS count_neutral, " +
                       "SUM(CASE WHEN f.feedback_rating = 3 THEN 1 ELSE 0 END) AS count_satisfied, " +
                       "SUM(CASE WHEN f.feedback_rating = 4 THEN 1 ELSE 0 END) AS count_verysatisfied, " +
                       "COUNT(f.feedback_rating) AS total_count " +
                       "FROM products p " +
                       "JOIN feedback f ON p.product_id = f.product_id " +
                       "GROUP BY p.product_name";

        Statement statement = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
        ResultSet resultSet = statement.executeQuery(query);

        DefaultTableModel model = (DefaultTableModel) dashboard.getProductsRanking().getModel();
        model.setRowCount(0);

        List<ProductRanking> rankings = new ArrayList<>();

        while (resultSet.next()) {
            String productName = resultSet.getString("product_name");
            int countDisatisfied = resultSet.getInt("count_disatisfied");
            int countNeutral = resultSet.getInt("count_neutral");
            int countSatisfied = resultSet.getInt("count_satisfied");
            int countVerySatisfied = resultSet.getInt("count_verysatisfied");
            int totalCount = resultSet.getInt("total_count");

            double countOverall = ((countDisatisfied * 1) + (countNeutral * 2) + (countSatisfied * 3) + (countVerySatisfied * 4)) / (double) totalCount;

            rankings.add(new ProductRanking(productName, countOverall));
        }

        // Sort the products by countOverall in descending order
        rankings.sort(Comparator.comparingDouble(ProductRanking::getCountOverall).reversed());

        int rank = 1;
        for (ProductRanking ranking : rankings) {
            Object[] rowData = {rank, ranking.getProductName(), ranking.getCountOverall()};
            model.addRow(rowData);
            rank++;
        }

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Failed to connect to database");
        }
    }
    class ProductRanking {
        private String productName;
        private double countOverall;

        public ProductRanking(String productName, double countOverall) {
            this.productName = productName;
            this.countOverall = countOverall;
        }

        public String getProductName() {
            return productName;
        }

        public double getCountOverall() {
            return countOverall;
        }
    }
    
    public void getRatingSum(){
        DefaultTableModel model = (DefaultTableModel) dashboard.getFeedbackTable().getModel();
        
        int count_disatisfied = 0;
        int count_neutral = 0;
        int count_satisfied = 0;
        int count_verysatisfied = 0;
        
        int numberofRow = model.getRowCount();
        for(int x = 0; x<numberofRow; x++){
            int result = Integer.parseInt(model.getValueAt(x, 3).toString());
            System.out.println(result);
             //check and sort result every iteration
             
            switch(result){
                case 1 -> count_disatisfied++;
                case 2 -> count_neutral++;
                case 3 -> count_satisfied++;
                case 4 -> count_verysatisfied++;
                    
                default -> JOptionPane.showMessageDialog(null, "out of format count rating: error");          
            }
            
        }
        try{
             System.out.println(count_disatisfied + " " + count_verysatisfied + " " + numberofRow);
             dashboard.updateFeedbackDetails(count_disatisfied, count_neutral, count_satisfied, count_verysatisfied);
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "error to get rating");
        }
        
    }
      
    public void selectProduct(MouseEvent evt){
        JTable productTable = dashboard.getProductsRanking();
        DefaultTableModel model = (DefaultTableModel) productTable.getModel();
        int viewRowIndex = productTable.rowAtPoint(evt.getPoint());
        int productID = 0;
        if (viewRowIndex >= 0) { // when a row is selected
            
            String ID = model.getValueAt(viewRowIndex, 1).toString();
            switch (ID) {
                case "IBM Security MaaS360":
                    productID = 1;
                    break;
                case "IBM Cloud Pak for Data":
                    productID = 2;
                    break;
                case "IBM Storage Defender":
                    productID = 3;
                    break;
                case "IBM Power Solution editions for healthcare":
                    productID = 4;
                    break;
                case "Storage Scale System":
                    productID = 5;
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "selectProduct error");
            }
            
            
            DefaultTableModel FBmodel = (DefaultTableModel) dashboard.getFeedbackTable().getModel();
            int numberofRow = FBmodel.getRowCount();
            

             DefaultTableModel ProductREVIEWS = (DefaultTableModel) dashboard.getCstmrFeedback().getModel();
             ProductREVIEWS.setRowCount(0);
            
            for(int i = 0; i<numberofRow; i++){
               if(Integer.parseInt(FBmodel.getValueAt(i, 1).toString()) == productID){
                   
                   Object response = FBmodel.getValueAt(i, 2);
                   Object[] rowData = {response};
                   ProductREVIEWS.addRow(rowData);

               }
            }

        //product review 2
            int count_disatisfied = 0;
            int count_neutral = 0;
            int count_satisfied = 0;
            int count_verysatisfied = 0;
            double count_overall = 0;
               
            for (int i = 0; i<numberofRow; i++) {
            if(Integer.parseInt(FBmodel.getValueAt(i, 1).toString()) == productID){
                
                    int score = Integer.parseInt(FBmodel.getValueAt(i, 3).toString());
                    
                    switch (score) {
                    case 1 -> count_disatisfied++;
                    case 2 -> count_neutral++;
                    case 3 -> count_satisfied++;
                    case 4 -> count_verysatisfied++;
                    default -> JOptionPane.showMessageDialog(null, "failed to get total rate scores");
                    }
                }
            }
            
           int total_count = count_disatisfied + count_neutral + count_satisfied + count_verysatisfied;
                if (total_count > 0) {
                    count_overall = ((count_disatisfied * 1) + (count_neutral * 2) + (count_satisfied * 3) + (count_verysatisfied * 4)) / (double) total_count;
                } else {
                    count_overall = 0; // or some other default value
                }
            dashboard.updateFeedbackRatings(count_disatisfied, count_neutral, count_satisfied, count_verysatisfied, count_overall, productID);
            
        }
        
        
        
    }
}
    
