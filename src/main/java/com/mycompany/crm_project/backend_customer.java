/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.crm_project;

import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public class backend_customer {
    private dashboard dashboard;
    
    //stores database data extension
            ArrayList<Integer> purchaseIDs = new ArrayList<>();
            ArrayList<String> feedbackContents = new ArrayList<>();
            ArrayList<Integer> customerIDs = new ArrayList<>();
    
     public backend_customer(dashboard dashboard) {
        this.dashboard = dashboard;
    }
    
    public void getTableC() {
        String url = "jdbc:mysql://localhost:3306/ibmcrm?zeroDateTimeBehavior=CONVERT_TO_NULL";
        String username = "root";
        String pass = "";
        
        Connection conn = null;
        
        try{
           Class.forName("com.mysql.cj.jdbc.Driver");
           conn = DriverManager.getConnection(url, username, pass);
           conn.setAutoCommit(false); //start transaction
           conn.setTransactionIsolation(Connection.TRANSACTION_REPEATABLE_READ);
           
           
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
                    resultSet.getString("customer_type"),
                    resultSet.getString("customer_note") // note when cliecked
                };
                model.addRow(rowData);  
            }       
            conn.commit();
        } catch (ClassNotFoundException | SQLException e) {
                if (conn != null) { // if transaction exist
                    try {
                        conn.rollback(); // Roll back the transaction if any operation fails
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }
                }
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Failed to connect to database");
            } finally {
                if (conn != null) { // if transaction exist
                    try {
                        conn.setAutoCommit(true); // Restore auto-commit mode
                        conn.close(); // Close the connection
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }
        }
    }
}
    

    public void selectcustomerProfile(MouseEvent evt) {
        JTable customerTable = dashboard.getCustomerTable();
        DefaultTableModel model = (DefaultTableModel) customerTable.getModel();
        selectCustomerExtensionData();
        int viewRowIndex = customerTable.rowAtPoint(evt.getPoint());
        if (viewRowIndex >= 0) { // when a row is selected
            
            int modelIndex = customerTable.convertRowIndexToModel(viewRowIndex); // retrieves correct data from model even if sorted
            
            String IDF = model.getValueAt(modelIndex, 0).toString(); // get corresponding id in the table
            int ID = Integer.parseInt(IDF); // parse the object - string into integer
            String customeFName = model.getValueAt(modelIndex, 1).toString(); // ~
            String customerLName = model.getValueAt(modelIndex, 3).toString();// ~
            String phoneNumber = model.getValueAt(modelIndex, 5).toString();  // ~
            String email; // declare var
            String customerNote; // declare var
            
            List<Integer> matchingPurchaseIDs = new ArrayList<>(); // stores multiple purchase id if availaible
            String cstmrFeedback = ""; // initalized; stores feedback from customer
            
            try{
                 email = model.getValueAt(modelIndex, 6).toString(); // ~
                 
            } catch(Exception e){
                 email = ""; 
            }
            
            try{
                customerNote = model.getValueAt(modelIndex, 8).toString(); // ~
                
            } catch (Exception e){
                 customerNote = "";
            }
            
            try {
             boolean matchFound = false; // initalize boolean to check for purchase IDs available for the customer selected in the table

             for (int i = 0; i < customerIDs.size(); i++) { //  iterate through arraylist containing database data (Customer IDs)
                 int getCurrentID = customerIDs.get(i);

                 if (getCurrentID == ID) {  // check for matching Customer IDs(database) and selected row (table - customer)
                     matchingPurchaseIDs.add(purchaseIDs.get(i)); // stores multiple purchase id if availaible
                     cstmrFeedback = feedbackContents.get(i); // stores feedback of customer id
                     matchFound = true;
                 }
             }

             if (matchFound) {
                 // Display all matching purchase IDs and feedback contents
                 for (int i = 0; i < matchingPurchaseIDs.size(); i++) {
                     int purchaseID = matchingPurchaseIDs.get(i);
//                     String feedback = matchingFeedbacks.get(i);
                     System.out.println("Purchase ID: " + purchaseID + ", Feedback: " + cstmrFeedback); // for debugging purposes
                 }
             } else {
                 System.out.println("no feedback"); 
             }
         } catch (Exception e) {
             e.printStackTrace();
             System.out.println("Error processing customer profile.");
         }

            
            
            try {
                //passes data backend to GUI
                dashboard.updateCustomerDetails(customeFName, customerLName, phoneNumber, email, customerNote, matchingPurchaseIDs, cstmrFeedback); 
            } catch (Exception e) {
                System.out.println("Failed to update customer details: " + e.getMessage());
            }
        }
    }
    
        
    public void searchFunction(JTextField searchbar) {
        DefaultTableModel model = (DefaultTableModel) dashboard.getCustomerTable().getModel();
        
        searchbar.getDocument().addDocumentListener(new DocumentListener() { //Listens for changes in the searchbar e.g., typing, clear, input
            @Override
            public void insertUpdate(DocumentEvent e) {
                filterTable();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                filterTable();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                // Not used in plain text components
            }

            private void filterTable() {
                String searchTerm = searchbar.getText().toLowerCase();
                TableRowSorter<TableModel> sorter = new TableRowSorter<>(model);
                dashboard.getCustomerTable().setRowSorter(sorter);
                if (searchTerm.isEmpty()) {
                    sorter.setRowFilter(null); // Clear the filter when the search bar is empty
                } else {
                    sorter.setRowFilter(RowFilter.regexFilter("(?i)" + searchTerm));
                }
            }
          
        });
          JTable updatedTable = new JTable(model);
          dashboard.updateSearchTable(updatedTable);
    }
    
    
    public TableModelListener NOTEChangeListener(){ // listens when note cell is changed e.g., updates note
         return e->{
             if(e.getType() == TableModelEvent.UPDATE){
            DefaultTableModel model = (DefaultTableModel) dashboard.getCustomerTable().getModel();
            int row = e.getFirstRow();
            int col = e.getColumn();

            if (col == 8) {    
            String newNote = (String) model.getValueAt(row, col);
            int ticketId = (int) model.getValueAt(row, 0); 
            updateNoteTo(ticketId, newNote); // calls backend database update function specified below 
         } else {
             JOptionPane.showMessageDialog(null, "Note ERROR occurred");  
            
         }
             }
           
         
         };
         
    }
    
    private void updateNoteTo(int customerID, String note) {  // backend database for note
        String url = "jdbc:mysql://localhost:3306/ibmcrm?zeroDateTimeBehavior=CONVERT_TO_NULL";
        String username = "root";
        String pass = "";

        Connection conn = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(url, username, pass);
            conn.setAutoCommit(false); // Start a transaction

            String query = "UPDATE customer SET customer_note = ? WHERE customer_id = ?";
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            preparedStatement.setString(1, note);
            preparedStatement.setInt(2, customerID);
            preparedStatement.executeUpdate();
                       
            conn.commit(); //commit transaction
            JOptionPane.showMessageDialog(null, "Note applied to database");
            
        } catch (ClassNotFoundException | SQLException e) {
             if (conn != null) {
            try {
                conn.rollback(); // Roll back the transaction if any operation fails
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        e.printStackTrace();
        JOptionPane.showMessageDialog(null, "Failed to connect to database");           
        } finally {
            if (conn != null) {
            try {
                conn.setAutoCommit(true); // Restore auto-commit mode
                conn.close(); // Close the connection
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        }
    }
    
 // extension details backend = feedback and purchase IDs asssociated with the customer (gets called in selectCustomerProfile above
   public void selectCustomerExtensionData() {
    String url = "jdbc:mysql://localhost:3306/ibmcrm?zeroDateTimeBehavior=CONVERT_TO_NULL";
    String username = "root";
    String pass = "";

    try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conn = DriverManager.getConnection(url, username, pass);

        // Declare ArrayLists to store purchase IDs, feedback content, and customer IDs
        purchaseIDs = new ArrayList<>();
        feedbackContents = new ArrayList<>();
        customerIDs = new ArrayList<>();

        // Retrieve purchase IDs, customer IDs, and feedback content
        String query = "SELECT p.purchase_id, p.customer_id, f.feedback_comment " +
                       "FROM purchase p " +
                       "LEFT JOIN feedback f ON p.customer_id = f.customer_id";
        Statement statement = conn.createStatement();
        ResultSet resultSet = statement.executeQuery(query);

        while (resultSet.next()) {
            int purchaseID = resultSet.getInt("purchase_id");
            int customerID = resultSet.getInt("customer_id");
            String feedbackContent = resultSet.getString("feedback_comment");

            purchaseIDs.add(purchaseID);
            customerIDs.add(customerID);
            feedbackContents.add(feedbackContent);
        }

        // Close resources
        resultSet.close();
        statement.close();
        conn.close();
    } catch (ClassNotFoundException | SQLException e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(null, "Failed to connect to database");
    }
}

    
    public void deleteCustomer(){
        String url = "jdbc:mysql://localhost:3306/ibmcrm?zeroDateTimeBehavior=CONVERT_TO_NULL";
        String username = "root";
        String pass = "";
        Connection conn = null;
        
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(url, username, pass);
            conn.setAutoCommit(false);
            
            JTable customerTable = dashboard.getCustomerTable();
            DefaultTableModel model = (DefaultTableModel) customerTable.getModel();
            int selectedRowIndex = customerTable.getSelectedRow();
            
         if (selectedRowIndex != -1) { // If a row is selected
            int selectedCustomerId = (int) model.getValueAt(selectedRowIndex, 0); // Assuming the first column is the customer ID
            String query = "DELETE FROM customer WHERE customer_id = ?";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, selectedCustomerId);
            pstmt.executeUpdate();
            model.removeRow(selectedRowIndex); // Remove the row from the table
            
            conn.commit(); // commit transaction
            JOptionPane.showMessageDialog(null, "Customer deleted successfully");
        } else {
            JOptionPane.showMessageDialog(null, "Please select a customer to delete");
        }   
        }catch(ClassNotFoundException | SQLException e){
            if (conn != null) {
            try {
                conn.rollback(); // Roll back the transaction if any operation fails
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        e.printStackTrace();
        JOptionPane.showMessageDialog(null, "Failed to delete customer from the database");
        } finally {
            if (conn != null) {
            try {
                conn.setAutoCommit(true); // Restore auto-commit mode
                conn.close(); // Close the connection
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        }
    }
}

