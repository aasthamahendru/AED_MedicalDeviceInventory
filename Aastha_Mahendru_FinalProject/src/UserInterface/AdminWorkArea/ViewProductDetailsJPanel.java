/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.AdminWorkArea;

import Business.Inventory.IDeviceType;
import Business.Supplier.SDeviceType;
import java.awt.CardLayout;
import javax.swing.JPanel;

/**
 *
 * @author Aastha
 */
public class ViewProductDetailsJPanel extends javax.swing.JPanel {

    JPanel upc;
    SDeviceType sdt;

    /**
     * Creates new form ViewProductDetailsJPanel
     */
    public ViewProductDetailsJPanel(JPanel upc, SDeviceType sdt) {
        initComponents();
        this.upc = upc;
        this.sdt = sdt;

        populateData();
    }

    public void populateData() {
        deviceNameJLabel.setText(sdt.getTypeOfDevice());
        modelNoJLabel.setText(String.valueOf(sdt.getModelNumber()));
        descriptionJLabel.setText(sdt.getDeviceDescription());
        priceJLabel.setText(String.valueOf(sdt.getCost()));
        maintenanceJLabel.setText(sdt.getMaintenanceProcedureDescription());
        maintenanceDueJLabel.setText("Regular maintenance must be carried out for this device after every " + String.valueOf(sdt.getMaintenanceDueAfter()) + " day(s).");
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
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        deviceNameJLabel = new javax.swing.JLabel();
        modelNoJLabel = new javax.swing.JLabel();
        descriptionJLabel = new javax.swing.JLabel();
        priceJLabel = new javax.swing.JLabel();
        maintenanceJLabel = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        backJButton = new javax.swing.JButton();
        maintenanceDueJLabel = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Device Name:");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 90, -1, -1));

        jLabel2.setText("Model No.:");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 120, -1, -1));

        jLabel3.setText("Device Description:");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 150, -1, -1));

        jLabel4.setText("Price:");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 180, -1, -1));

        jLabel5.setText("Maintenance Description:");
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 210, -1, -1));

        deviceNameJLabel.setText("jLabel6");
        add(deviceNameJLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 90, -1, -1));

        modelNoJLabel.setText("jLabel7");
        add(modelNoJLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 120, -1, -1));

        descriptionJLabel.setText("jLabel8");
        add(descriptionJLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 150, -1, -1));

        priceJLabel.setText("jLabel9");
        add(priceJLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 180, -1, -1));

        maintenanceJLabel.setText("jLabel10");
        add(maintenanceJLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 210, -1, -1));

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel11.setText("Device Details");
        add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 30, -1, -1));

        backJButton.setText("<<Back");
        backJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backJButtonActionPerformed(evt);
            }
        });
        add(backJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(48, 475, -1, -1));
        add(maintenanceDueJLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 250, 404, 23));
    }// </editor-fold>//GEN-END:initComponents

    private void backJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backJButtonActionPerformed
        upc.remove(this);
        CardLayout layout = (CardLayout) upc.getLayout();
        layout.previous(upc);

        // for (OrderItem oi : order.getListOfItemsOrdered()) {
        //   oi.getProduct().setAvailability(oi.getQuantity() + oi.getProduct().getAvailability());
        //}
    }//GEN-LAST:event_backJButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backJButton;
    private javax.swing.JLabel descriptionJLabel;
    private javax.swing.JLabel deviceNameJLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel maintenanceDueJLabel;
    private javax.swing.JLabel maintenanceJLabel;
    private javax.swing.JLabel modelNoJLabel;
    private javax.swing.JLabel priceJLabel;
    // End of variables declaration//GEN-END:variables
}
