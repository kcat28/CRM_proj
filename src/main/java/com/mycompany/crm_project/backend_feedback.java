/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.crm_project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Jep
 */
public class backend_feedback {
    private dashboard dashboard;
    ArrayList<String> feedbackcomment = new ArrayList<>();
    ArrayList<Integer> productID = new ArrayList<>();

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
                    //productID.add(resultSet.getInt("product_id")),
                    resultSet.getString("feedback_comment"),
                    //feedbackcomment.add(resultSet.getString("feedback_comment")),
                    resultSet.getString("feedback_rating"),
                    
                 
                };
                model.addRow(rowData);  
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
    
