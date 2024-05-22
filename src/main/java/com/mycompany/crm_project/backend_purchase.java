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
import java.util.HashSet;
import java.util.Set;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Acer
 */
public class backend_purchase {
    private dashboard dashboard;
    
    public backend_purchase(dashboard dashboard){
        this.dashboard = dashboard;
    }
    
    public void getTableP(){
        String url = "jdbc:mysql://localhost:3306/ibmcrm?zeroDateTimeBehavior=CONVERT_TO_NULL";
        String username = "root";
        String pass = "";
        
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(url, username, pass);
            
            String query = "SELECT * FROM purchase";
            Statement statement = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet resultSet = statement.executeQuery(query);
            
            DefaultTableModel model = (DefaultTableModel) dashboard.getPurchaseTable().getModel();
            model.setRowCount(0);
            
            while(resultSet.next()){
                Object[] rowData = {
                    resultSet.getInt("purchase_id"), //ticket ID
                    resultSet.getInt("customer_id"),
                    resultSet.getInt("product_id"),
                    resultSet.getInt("purchase_quantity"),
                    resultSet.getDouble("purchase_total"),
                    resultSet.getString("purchase_servicelength"),
                    resultSet.getString("purchase_datetime"),

                 
                };
                model.addRow(rowData);  
            }
            
        } catch(ClassNotFoundException | SQLException e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Failed to connect to database");
        }
    }
    
    
    //check every row for purchase quantity = orders, customers = unique id, earnings = purchase total
   public void getPurchaseDetails(){
    DefaultTableModel model = (DefaultTableModel) dashboard.getPurchaseTable().getModel();
    
    int count_orders = model.getRowCount(); // total orders
    double totalEarnings = 0.0;  // total earnings
    
    Set<Integer> uniqueCustomers = new HashSet<>();
    for (int x = 0; x < count_orders; x++) {
        try {
            int customerId = (int) model.getValueAt(x, 1);
            uniqueCustomers.add(customerId);
            
            double earnings = (double) model.getValueAt(x, 4);
            totalEarnings += earnings; 
        } catch (NumberFormatException e) {
           
            System.err.println("Error parsing data in row " + (x + 1));
            e.printStackTrace();
        }
    }
    
    int count_customers = uniqueCustomers.size();// total customers (Unique)
   
    
    try {
        dashboard.updatePurchaseDetails(count_orders, count_customers, totalEarnings);
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Error updating purchase details");
    }
}

}
