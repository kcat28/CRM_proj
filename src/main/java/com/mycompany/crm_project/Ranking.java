/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.mycompany.crm_project;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import com.mycompany.crm_project.dashboard;

/**
 *
 * @author Jep
 */
public class Ranking extends javax.swing.JPanel {
    private String PNAME;
    private backend_feedback BF;
 
    public Ranking(String Pname) {
        this.PNAME = Pname;
        initComponents();
        ProductName.setText(PNAME);
        init();
    }
    
    public Ranking(dashboard dashboard){
        this.BF = new backend_feedback(dashboard);
         initComponents();
          init();
    }
    

    
    public void init(){
        
        addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
                icon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/productselected.png")));
                JOptionPane.showMessageDialog(null, "Product Name: " + PNAME);
               BF.getAllFeedback(PNAME);
            } 
        });
    }
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        icon = new javax.swing.JLabel();
        ProductName = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        icon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/productdefault.png"))); // NOI18N

        ProductName.setFont(new java.awt.Font("IBM Plex Sans", 0, 12)); // NOI18N
        ProductName.setText("Product ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(icon)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(ProductName)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(icon, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(ProductName)
                .addGap(20, 20, 20))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel ProductName;
    private javax.swing.JLabel icon;
    // End of variables declaration//GEN-END:variables
}
