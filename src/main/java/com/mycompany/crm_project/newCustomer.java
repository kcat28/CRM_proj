/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.crm_project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author Acer
 */
public class newCustomer extends javax.swing.JFrame {

    /**
     * Creates new form NewJFrame
     */
    public newCustomer() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        CT = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        MN = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        LN = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        CN = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        FN = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        CONTACT = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        EMAILADD = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(110, 127, 145));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel1.add(CT, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 260, 150, -1));

        jLabel1.setFont(new java.awt.Font("IBM Plex Sans Medium", 0, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Customer Type");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 260, -1, 20));

        jLabel2.setFont(new java.awt.Font("IBM Plex Sans Medium", 0, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText(" Middle Name");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 110, 100, 20));
        jPanel1.add(MN, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 110, 150, -1));

        jLabel3.setFont(new java.awt.Font("IBM Plex Sans Medium", 0, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Last Name");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 140, 90, 20));
        jPanel1.add(LN, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 140, 150, -1));

        jLabel5.setFont(new java.awt.Font("IBM Plex Sans Medium", 0, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Company Name");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 170, -1, 20));
        jPanel1.add(CN, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 170, 150, -1));

        jLabel6.setFont(new java.awt.Font("IBM Plex Sans Medium", 0, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText(" First Name");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 80, 70, 20));

        FN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FNActionPerformed(evt);
            }
        });
        jPanel1.add(FN, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 80, 150, -1));

        jLabel7.setFont(new java.awt.Font("IBM Plex Sans Medium", 0, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Contact No");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 200, -1, 20));
        jPanel1.add(CONTACT, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 200, 150, -1));

        jLabel8.setFont(new java.awt.Font("IBM Plex Sans Medium", 0, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Email Address");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 230, -1, 20));
        jPanel1.add(EMAILADD, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 230, 150, -1));

        jButton1.setFont(new java.awt.Font("IBM Plex Sans Medium", 0, 12)); // NOI18N
        jButton1.setText("Create");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 340, -1, -1));

        jButton2.setFont(new java.awt.Font("IBM Plex Sans Medium", 0, 12)); // NOI18N
        jButton2.setText("Cancel");
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 340, -1, -1));

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setFont(new java.awt.Font("IBM Plex Sans Medium", 0, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Create New Customer Profile");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 340, 420));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void FNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FNActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_FNActionPerformed

    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jButton2MouseClicked

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        // TODO add your handling code here:
        createCustomerPrfl();
        
    }//GEN-LAST:event_jButton1MouseClicked
       public void createCustomerPrfl(){
        String url = "jdbc:mysql://localhost:3306/ibmcrm?zeroDateTimeBehavior=CONVERT_TO_NULL";
        String username = "root";
        String pass = "";

        String fname = FN.getText();
        String mname = MN.getText();
        String lname = LN.getText();
        String cn = CN.getText();
        String contact = CONTACT.getText();
        String email = EMAILADD.getText();
        String customer = CT.getText();
        
        if (fname.isEmpty() || mname.isEmpty() || lname.isEmpty() || cn.isEmpty() || contact.isEmpty() || email.isEmpty() || customer.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please fill in all the fields");
            return; // Stop further execution
        } else if (!email.contains("@")){
            JOptionPane.showMessageDialog(null, "Incorrect Email Format");
            return; // Stop further execution
        } else if (fname.matches(".*\\d.*") || mname.matches(".*\\d.*") || lname.matches(".*\\d.*")){
            JOptionPane.showMessageDialog(null, "Incorrect Name Format");
            return; // Stop further execution
        }
        
        
        try{
           Class.forName("com.mysql.cj.jdbc.Driver");
           Connection conn = DriverManager.getConnection(url, username, pass);
           String query = "INSERT INTO customer (first_name, middle_name, last_name, company_name, contact_number, contact_email, customer_type) VALUES(?, ?, ?, ?, ?, ?,?)";
           PreparedStatement preparedStatement = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
           
            preparedStatement.setString(1, fname);
            preparedStatement.setString(2, mname);
            preparedStatement.setString(3, lname);
            preparedStatement.setString(4, cn);
            preparedStatement.setString(5, contact);
            preparedStatement.setString(6, email);
            preparedStatement.setString(7, customer);
            preparedStatement.executeUpdate();
            
            
            ResultSet rs = preparedStatement.getGeneratedKeys();
            int maxCustomerId = 0;
            if (rs.next()) {
                maxCustomerId = rs.getInt(1);
            }
            rs.close();

            // Reset the auto-increment value
            String alterQuery = "ALTER TABLE customer AUTO_INCREMENT = ?";
            PreparedStatement alterStatement = conn.prepareStatement(alterQuery);
            alterStatement.setInt(1, maxCustomerId + 1);
            alterStatement.executeUpdate();
            alterStatement.close();

            JOptionPane.showMessageDialog(null, "Customer Profile Created Successfully");

            conn.close();
            this.dispose();
        } catch(ClassNotFoundException| SQLException e){
            
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Failed to create user to database");
        }
        
    }
    
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(newCustomer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(newCustomer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(newCustomer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(newCustomer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new newCustomer().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField CN;
    private javax.swing.JTextField CONTACT;
    private javax.swing.JTextField CT;
    private javax.swing.JTextField EMAILADD;
    private javax.swing.JTextField FN;
    private javax.swing.JTextField LN;
    private javax.swing.JTextField MN;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
