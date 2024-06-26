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
import javax.swing.UIManager;

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

        jPanel3 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        passIcon = new javax.swing.JLabel();
        emailIcon = new javax.swing.JLabel();
        lines1 = new javax.swing.JLabel();
        customerConnect = new javax.swing.JLabel();
        password = new javax.swing.JPasswordField();
        email = new javax.swing.JTextField();
        showIcon = new javax.swing.JLabel();
        hideIcon = new javax.swing.JLabel();
        Login = new javax.swing.JButton();
        lines3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(10, 30, 69));
        setMinimumSize(new java.awt.Dimension(718, 360));
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(10, 30, 69));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(48, 66, 106));
        jPanel1.setMaximumSize(new java.awt.Dimension(400, 260));
        jPanel1.setMinimumSize(new java.awt.Dimension(400, 260));
        jPanel1.setPreferredSize(new java.awt.Dimension(400, 260));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        passIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/icons8-password-26.png"))); // NOI18N
        jPanel1.add(passIcon, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, 30, 50));

        emailIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/icons8-user-shield-32.png"))); // NOI18N
        jPanel1.add(emailIcon, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, -1, 30));

        lines1.setForeground(new java.awt.Color(255, 255, 255));
        lines1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/line.png"))); // NOI18N
        lines1.setToolTipText("");
        jPanel1.add(lines1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 190, 190, 10));

        customerConnect.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/Group 28 (4).png"))); // NOI18N
        jPanel1.add(customerConnect, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, 160, 60));

        password.setBackground(new java.awt.Color(48, 66, 106));
        password.setFont(new java.awt.Font("IBM Plex Sans", 0, 14)); // NOI18N
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
        jPanel1.add(password, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 170, 150, 20));

        email.setBackground(new java.awt.Color(48, 66, 106));
        email.setFont(new java.awt.Font("IBM Plex Sans", 0, 14)); // NOI18N
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
        jPanel1.add(email, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 80, 170, 30));

        showIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/icons8-show-26.png"))); // NOI18N
        showIcon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                showIconMouseClicked(evt);
            }
        });
        jPanel1.add(showIcon, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 170, 30, -1));

        hideIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/icons8-hide-26.png"))); // NOI18N
        hideIcon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                hideIconMouseClicked(evt);
            }
        });
        jPanel1.add(hideIcon, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 170, -1, -1));

        Login.setBackground(new java.awt.Color(110, 127, 145));
        Login.setFont(new java.awt.Font("IBM Plex Sans SemiBold", 0, 14)); // NOI18N
        Login.setForeground(new java.awt.Color(255, 255, 255));
        Login.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/icons8-login-30.png"))); // NOI18N
        Login.setToolTipText("");
        Login.setBorder(null);
        Login.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/icons8-login-30 (1).png"))); // NOI18N
        Login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LoginActionPerformed(evt);
            }
        });
        jPanel1.add(Login, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 250, 90, 30));

        lines3.setForeground(new java.awt.Color(255, 255, 255));
        lines3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/line.png"))); // NOI18N
        lines3.setToolTipText("");
        jPanel1.add(lines3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, 190, 10));

        jPanel3.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 40, 280, 280));

        jLabel1.setFont(new java.awt.Font("IBM Plex Sans SemiBold", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("     X");
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });
        jPanel3.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 0, 40, 40));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/login background.png"))); // NOI18N
        jLabel2.setText("jLabel2");
        jPanel3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 720, -1));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 720, 360));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_jLabel1MouseClicked

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

    private void hideIconMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_hideIconMouseClicked
        // TODO add your handling code here:
        password.setEchoChar('\u2022');
        hideIcon.setVisible(false);
        hideIcon.setEnabled(false);
        showIcon.setVisible(true);
        showIcon.setEnabled(true);
    }//GEN-LAST:event_hideIconMouseClicked

    private void showIconMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_showIconMouseClicked
        // TODO add your handling code here:
        password.setEchoChar((char)0);
        hideIcon.setVisible(true);
        hideIcon.setEnabled(true);
        showIcon.setVisible(false);
        showIcon.setEnabled(false);
    }//GEN-LAST:event_showIconMouseClicked

    private void emailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_emailActionPerformed

    private void emailFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_emailFocusLost
        // TODO add your handling code here:
        if(email.getText().equals("")){
            email.setText("Email");
        }
    }//GEN-LAST:event_emailFocusLost

    private void emailFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_emailFocusGained
        // TODO add your handling code here:
        if(email.getText().equals("Email")){
            email.setText("");
        }
    }//GEN-LAST:event_emailFocusGained

    private void passwordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passwordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_passwordActionPerformed

    private void passwordFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_passwordFocusLost
        // TODO add your handling code here:
        if (password.getText().equals("")) {
            password.setText("Password");
            password.setEchoChar((char)0);
        }

    }//GEN-LAST:event_passwordFocusLost

    private void passwordFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_passwordFocusGained
        // TODO add your handling code here:
        if (password.getText().equals("Password")){
            password.setText("");
            password.setEchoChar('\u2022');
        }
        else {
            password.selectAll();
        }
    }//GEN-LAST:event_passwordFocusGained

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
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
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
    private javax.swing.JLabel customerConnect;
    private javax.swing.JTextField email;
    private javax.swing.JLabel emailIcon;
    private javax.swing.JLabel hideIcon;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel lines1;
    private javax.swing.JLabel lines3;
    private javax.swing.JLabel passIcon;
    private javax.swing.JPasswordField password;
    private javax.swing.JLabel showIcon;
    // End of variables declaration//GEN-END:variables
}
