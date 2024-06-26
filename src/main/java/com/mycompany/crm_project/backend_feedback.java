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
       try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(url, username, pass);
            
            String query = "SELECT SUM(f.feedback_rating) AS total_rating, p.product_name\n" +
                            "FROM products p\n" +
                            "JOIN feedback f ON p.product_id = f.product_id\n" +
                            "GROUP BY p.product_name";
            Statement statement = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet resultSet = statement.executeQuery(query);
            
            DefaultTableModel model = (DefaultTableModel) dashboard.getProductsRanking().getModel();
            model.setRowCount(0);
            
            
            int rank = 1;
            while(resultSet.next()){
            String productName = resultSet.getString("product_name");
            int totalRating = resultSet.getInt("total_rating");
            
            
                Object[] rowData = {rank, productName};
                model.addRow(rowData);  
                 rank++;
            }
        
            
        } catch(ClassNotFoundException | SQLException e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Failed to connect to database");
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
    
    public void getRatingSum(String ID){
        
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
            dashboard.updateFeedbackRatings(count_disatisfied, count_neutral, count_satisfied, count_verysatisfied, count_overall);
    }
}
    
    public void getAllFeedback (String PNAME) {
        DefaultTableModel model = (DefaultTableModel) dashboard.getFeedbackTable().getModel();
        DefaultTableModel model2 = (DefaultTableModel) dashboard.getCstmrFeedback().getModel();
        model2.setRowCount(0);
        
        int numberofRow = model.getRowCount();
         for(int x = 0; x< numberofRow; x++){ 
             String currentPN = (String) "Product " + model.getValueAt(x, 1);
             
                if (currentPN.equalsIgnoreCase(PNAME)){
                      Object rowData  = model.getValueAt(x, 2);
               
                 try{
              model2.addRow(new Object[]{rowData});
             } catch (Exception e){
                  JOptionPane.showMessageDialog(null, "error to pass feedback on products");
             }
                }
             }   
         
         }
    
    
    
  
    }
    
