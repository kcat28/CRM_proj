/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.crm_project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author Nicole Danga
 */
public class Login extends javax.swing.JFrame {

    /**
     * Creates new form Login
     */
    public Login() {
        initComponents();
        
        String imagePath = getClass().getResource("/imgs/ibm_connect.png").getPath();
        System.out.println("Image Path: " + imagePath);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        hideIcon = new javax.swing.JLabel();
        showIcon = new javax.swing.JLabel();
        email = new javax.swing.JTextField();
        password = new javax.swing.JPasswordField();
        customerConnect = new javax.swing.JLabel();
        Login = new javax.swing.JButton();
        lines1 = new javax.swing.JLabel();
        lines2 = new javax.swing.JLabel();
        emailIcon = new javax.swing.JLabel();
        passIcon = new javax.swing.JLabel();
        bg = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1405, 823));
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(1405, 823));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("IBM Plex Sans SemiBold", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("X");
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1335, 40, -1, -1));

        hideIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/hide (3).png"))); // NOI18N
        hideIcon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                hideIconMouseClicked(evt);
            }
        });
        getContentPane().add(hideIcon, new org.netbeans.lib.awtextra.AbsoluteConstraints(1219, 488, -1, -1));

        showIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/visible.png"))); // NOI18N
        showIcon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                showIconMouseClicked(evt);
            }
        });
        getContentPane().add(showIcon, new org.netbeans.lib.awtextra.AbsoluteConstraints(1220, 490, -1, -1));

        email.setBackground(new java.awt.Color(49, 66, 104));
        email.setFont(new java.awt.Font("IBM Plex Sans", 0, 30)); // NOI18N
        email.setForeground(new java.awt.Color(255, 255, 255));
        email.setText("Email");
        email.setBorder(null);
        email.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                emailFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                emailFocusLost(evt);
            }
        });
        email.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emailActionPerformed(evt);
            }
        });
        getContentPane().add(email, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 390, 440, -1));

        password.setBackground(new java.awt.Color(47, 65, 106));
        password.setFont(new java.awt.Font("IBM Plex Sans", 0, 30)); // NOI18N
        password.setForeground(new java.awt.Color(255, 255, 255));
        password.setText("Password");
        password.setBorder(null);
        password.setEchoChar((char)0);
        password.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                passwordFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                passwordFocusLost(evt);
            }
        });
        password.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passwordActionPerformed(evt);
            }
        });
        getContentPane().add(password, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 500, 340, -1));

        customerConnect.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/IBM_CONNECT (4).png"))); // NOI18N
        getContentPane().add(customerConnect, new org.netbeans.lib.awtextra.AbsoluteConstraints(745, 70, 600, 220));

        Login.setBackground(new java.awt.Color(2, 25, 47));
        Login.setFont(new java.awt.Font("IBM Plex Sans SemiBold", 0, 36)); // NOI18N
        Login.setForeground(new java.awt.Color(255, 255, 255));
        Login.setText("LOG IN");
        Login.setToolTipText("");
        Login.setBorder(null);
        Login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LoginActionPerformed(evt);
            }
        });
        getContentPane().add(Login, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 620, 200, 60));

        lines1.setForeground(new java.awt.Color(255, 255, 255));
        lines1.setText("______________________________________________________________________");
        lines1.setToolTipText("");
        getContentPane().add(lines1, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 420, 540, 40));

        lines2.setForeground(new java.awt.Color(255, 255, 255));
        lines2.setText("______________________________________________________________________");
        getContentPane().add(lines2, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 540, 540, -1));

        emailIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/email (4).png"))); // NOI18N
        getContentPane().add(emailIcon, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 370, -1, -1));

        passIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/pass (2).png"))); // NOI18N
        getContentPane().add(passIcon, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 480, -1, -1));

        bg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/Group 28 (1).png"))); // NOI18N
        getContentPane().add(bg, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 0, 1400, 820));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void passwordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passwordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_passwordActionPerformed

    private void emailFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_emailFocusGained
        // TODO add your handling code here:
        if(email.getText().equals("Email")){
            email.setText("");
        }
    }//GEN-LAST:event_emailFocusGained

    private void emailFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_emailFocusLost
        // TODO add your handling code here:
        if(email.getText().equals("")){
            email.setText("Email");
        }
    }//GEN-LAST:event_emailFocusLost

    private void LoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LoginActionPerformed
        // TODO add your handling code here:
        String userEmail = email.getText();
        String userPassword = new String(password.getPassword()); // Convert char[] to String
        
        if (userEmail.isEmpty() ||  userPassword.isEmpty()) {
            javax.swing.JOptionPane.showMessageDialog(this, "Please enter email and password.");
            return;
        } 
        
        
        try {
            Connection conn = DBConnect();
            if (conn == null) {
                JOptionPane.showMessageDialog(this, "Failed to connect to the database.");
                return;
            }
            
            String sql = "SELECT * FROM login WHERE email = ? AND password = ?";
              //used to safely insert values into the SQL statement.
              //'?' as placeholders for parameters to be set later
              PreparedStatement pst = conn.prepareStatement(sql); 
              pst.setString(1, userEmail); // sets the first placeholder (?) to userEmail
              pst.setString(2, userPassword); // sets the second placeholder (?) to userPassword
              
              ResultSet rs = pst.executeQuery(); //execute insertion
              
              if (rs.next()) {
                // Successful login
                javax.swing.JOptionPane.showMessageDialog(this, "Login successful!");
                // Redirect to the next page or perform another action
                new dashboard().setVisible(true);
                this.dispose();
               } else {
                // Login failed
                javax.swing.JOptionPane.showMessageDialog(this, "Invalid email or password.");
               }
            
               rs.close();
               pst.close();
               conn.close();
               
        } catch(Exception e){
              // Handle any exceptions that occur during the database connection or query execution
              e.printStackTrace();
              javax.swing.JOptionPane.showMessageDialog(this, "Database connection error: " + e.getMessage());
            }
    }//GEN-LAST:event_LoginActionPerformed

    private void passwordFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_passwordFocusGained
        // TODO add your handling code here:
        if (password.getText().equals("Password")){
            password.setText("");
            password.setEchoChar((char)8226);
        }
        else {
            password.selectAll();
        }
    }//GEN-LAST:event_passwordFocusGained

    private void passwordFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_passwordFocusLost
        // TODO add your handling code here:
        if (password.getText().equals("")) {
            password.setText("Password");
            password.setEchoChar((char)0);
        }
               
    }//GEN-LAST:event_passwordFocusLost

    private void emailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_emailActionPerformed

    private void showIconMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_showIconMouseClicked
        // TODO add your handling code here:
        password.setEchoChar((char)8226);
        hideIcon.setVisible(true);
        hideIcon.setEnabled(true);
        showIcon.setEnabled(false);
        showIcon.setEnabled(false);
    }//GEN-LAST:event_showIconMouseClicked

    private void hideIconMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_hideIconMouseClicked
        // TODO add your handling code here:
        password.setEchoChar((char)0);
        hideIcon.setVisible(false);
        hideIcon.setEnabled(false);
        showIcon.setEnabled(true);
        showIcon.setEnabled(true);
    }//GEN-LAST:event_hideIconMouseClicked

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_jLabel1MouseClicked

    private Connection DBConnect(){
        String url = "jdbc:mysql://localhost:3306/ibmcrm?zeroDateTimeBehavior=CONVERT_TO_NULL"; // JDBC URL for connecting to the database
        String username = "root"; // Database username
        String pass = ""; // Database password (blank in this case)
        
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(url, username, pass);
            System.out.println("Connected");
            return conn;
        }catch(Exception e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e);
            return null;
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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Login;
    private javax.swing.JLabel bg;
    private javax.swing.JLabel customerConnect;
    private javax.swing.JTextField email;
    private javax.swing.JLabel emailIcon;
    private javax.swing.JLabel hideIcon;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lines1;
    private javax.swing.JLabel lines2;
    private javax.swing.JLabel passIcon;
    private javax.swing.JPasswordField password;
    private javax.swing.JLabel showIcon;
    // End of variables declaration//GEN-END:variables
}
