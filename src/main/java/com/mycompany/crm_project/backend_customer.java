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
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class backend_customer {
    private dashboard dashboard;
    
     public backend_customer(dashboard dashboard) {
        this.dashboard = dashboard;
    }
    
    public void getTable() {
        String url = "jdbc:mysql://localhost:3306/ibmcrm?zeroDateTimeBehavior=CONVERT_TO_NULL";
        String username = "root";
        String pass = "";
        
        try{
           Class.forName("com.mysql.cj.jdbc.Driver");
           Connection conn = DriverManager.getConnection(url, username, pass);
           
           String query = "SELECT * FROM customer";
           Statement statement = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
           ResultSet resultSet = statement.executeQuery(query);
          
            DefaultTableModel model = (DefaultTableModel) dashboard.getCustomerTable().getModel();
            model.setRowCount(0);
            
            while(resultSet.next()){
                
                Object[] rowData = {
                    resultSet.getInt("customer_id"), //ticket ID
                    resultSet.getString("first_name"),
                    resultSet.getString("middle_name"),
                    resultSet.getString("last_name"),
                    resultSet.getString("company_name"),
                    resultSet.getString("contact_number"),
                    resultSet.getString("contact_email"),
                    resultSet.getString("customer_type")
                   // resultSet.getString("customer_note"), // note when cliecked
                };
                model.addRow(rowData);  
            }       
           
        } catch(ClassNotFoundException | SQLException e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Failed to connect to database");
        }
        
    }
}
