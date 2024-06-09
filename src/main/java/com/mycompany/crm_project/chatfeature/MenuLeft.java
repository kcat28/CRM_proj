package com.mycompany.crm_project.chatfeature;
import com.mycompany.crm_project.chatfeature.components.Item_People;
import net.miginfocom.swing.MigLayout;
public class MenuLeft extends javax.swing.JPanel {

    public MenuLeft() {
        initComponents();
        init();
    }

private void init(){
    menuList.setLayout(new MigLayout("fillx", "0[]0", "1[]1"));
    showPeople();
}

private void showPeople(){
        for(int i = 0; i<3; i++){
            menuList.add(new Item_People("People" + i), "Wrap");
        }
}
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        menu = new javax.swing.JLayeredPane();
        menuButton1 = new com.mycompany.crm_project.chatfeature.components.MenuButton();
        menuButton2 = new com.mycompany.crm_project.chatfeature.components.MenuButton();
        menuButton3 = new com.mycompany.crm_project.chatfeature.components.MenuButton();
        menuList = new javax.swing.JLayeredPane();

        setBackground(new java.awt.Color(48, 89, 127));

        menu.setBackground(new java.awt.Color(246, 246, 246));
        menu.setOpaque(true);
        menu.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        menuButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/chatIcons/message.png"))); // NOI18N
        menuButton1.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/chatIcons/message_selected.png"))); // NOI18N
        menuButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuButton1MouseClicked(evt);
            }
        });
        menuButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuButton1ActionPerformed(evt);
            }
        });
        menu.add(menuButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 60, 40));

        menuButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/chatIcons/group.png"))); // NOI18N
        menuButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuButton2ActionPerformed(evt);
            }
        });
        menu.add(menuButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 0, 60, 40));

        menuButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/chatIcons/box.png"))); // NOI18N
        menuButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuButton3ActionPerformed(evt);
            }
        });
        menu.add(menuButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 0, 60, 40));

        menuList.setBackground(new java.awt.Color(48, 89, 127));

        javax.swing.GroupLayout menuListLayout = new javax.swing.GroupLayout(menuList);
        menuList.setLayout(menuListLayout);
        menuListLayout.setHorizontalGroup(
            menuListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        menuListLayout.setVerticalGroup(
            menuListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 537, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(menu)
            .addComponent(menuList)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(menu, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(menuList))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void menuButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_menuButton1ActionPerformed

    private void menuButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_menuButton2ActionPerformed

    private void menuButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuButton3ActionPerformed
        // TODO add your handling code here:
        menuButton1.setSelected(false);
    }//GEN-LAST:event_menuButton3ActionPerformed

    private void menuButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuButton1MouseClicked
        // TODO add your handling code here:
        menuButton1.setSelected(true);
    }//GEN-LAST:event_menuButton1MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLayeredPane menu;
    private com.mycompany.crm_project.chatfeature.components.MenuButton menuButton1;
    private com.mycompany.crm_project.chatfeature.components.MenuButton menuButton2;
    private com.mycompany.crm_project.chatfeature.components.MenuButton menuButton3;
    private javax.swing.JLayeredPane menuList;
    // End of variables declaration//GEN-END:variables
}
