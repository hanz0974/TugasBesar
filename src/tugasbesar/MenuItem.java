/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package tugasbesar;

import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.Icon;

/**
 *
 * @author MyPC One Pro K
 */
public class MenuItem extends javax.swing.JPanel {

    public ArrayList<MenuItem> getSubMenu(){
        return subMenu;
    
    }
    private final ArrayList<MenuItem> subMenu = new ArrayList<>();
    private ActionListener act; 
    
    
    public MenuItem(Icon icon,boolean sbm, Icon iconSub, String menuName,ActionListener act, MenuItem...subMenu ) {
        initComponents();
        
        lb_Icon.setIcon(icon);
        lb_menuName.setText(menuName);
        lb_IconSub.setIcon(iconSub);
        lb_IconSub.setVisible(sbm);
        
        if(act != null){
            this.act = act;
        }
        
        this.setSize(new Dimension(Integer.MAX_VALUE, 45));
        this.setMaximumSize(new Dimension(Integer.MAX_VALUE, 45));
        this.setMinimumSize(new Dimension(Integer.MAX_VALUE, 45));
        for (int i = 0; i < subMenu.length; i++){
            this.subMenu.add(subMenu[i]);
            subMenu[i].setVisible(false);
        }
        
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lb_menuName = new javax.swing.JLabel();
        lb_Icon = new javax.swing.JLabel();
        lb_IconSub = new javax.swing.JLabel();

        lb_menuName.setText("Menu Item...");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(lb_Icon, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lb_IconSub, javax.swing.GroupLayout.DEFAULT_SIZE, 55, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lb_menuName, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lb_menuName, javax.swing.GroupLayout.DEFAULT_SIZE, 58, Short.MAX_VALUE)
            .addComponent(lb_Icon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(lb_IconSub, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lb_Icon;
    private javax.swing.JLabel lb_IconSub;
    private javax.swing.JLabel lb_menuName;
    // End of variables declaration//GEN-END:variables
}