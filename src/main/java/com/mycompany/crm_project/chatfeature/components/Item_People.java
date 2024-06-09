
package com.mycompany.crm_project.chatfeature.components;
public class Item_People extends javax.swing.JPanel {

    public Item_People(String name) {
        initComponents();
        lb.setText(name);
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        imageAvatar1 = new com.mycompany.crm_project.chatfeature.components.ImageAvatar();
        lb = new javax.swing.JLabel();

        setBackground(new java.awt.Color(48, 89, 127));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        imageAvatar1.setBorderSize(0);
        imageAvatar1.setImage(new javax.swing.ImageIcon(getClass().getResource("/chatIcons/icon3.png"))); // NOI18N
        imageAvatar1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        add(imageAvatar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 0, 51, 50));

        lb.setFont(new java.awt.Font("IBM Plex Sans", 0, 14)); // NOI18N
        lb.setForeground(new java.awt.Color(255, 255, 255));
        lb.setText("Jonathan Lugh");
        add(lb, new org.netbeans.lib.awtextra.AbsoluteConstraints(63, 14, 130, -1));
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.mycompany.crm_project.chatfeature.components.ImageAvatar imageAvatar1;
    private javax.swing.JLabel lb;
    // End of variables declaration//GEN-END:variables
}
