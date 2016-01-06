/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.Supplier;

import Business.Supplier.SDeviceType;
import java.awt.CardLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Aastha
 */
public class ViewProductDetailsJPanel extends javax.swing.JPanel {

    JPanel upc;
    SDeviceType p;

    /**
     * Creates new form ViewProductDetailsJPanel
     */
    public ViewProductDetailsJPanel(JPanel upc, SDeviceType p) {
        initComponents();
        this.upc = upc;
        this.p = p;
        populateFields();
    }

    public void populateFields() {
        pNameJTextField.setText(p.getTypeOfDevice());
        pIDJTextField.setText(String.valueOf(p.getModelNumber()));
        pPriceJTextField.setText(String.valueOf(p.getCost()));
        devicedescriptionJTextArea.setText(p.getDeviceDescription());
        maintenanceJTextArea.setText(p.getMaintenanceProcedureDescription());
        maintenancedueJTextField.setText(String.valueOf(p.getMaintenanceDueAfter()));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        productNameJLabel = new javax.swing.JLabel();
        priceJLabel = new javax.swing.JLabel();
        productIDJLabel = new javax.swing.JLabel();
        panelTitleJLabel = new javax.swing.JLabel();
        pIDJTextField = new javax.swing.JTextField();
        pNameJTextField = new javax.swing.JTextField();
        pPriceJTextField = new javax.swing.JTextField();
        updateJButton = new javax.swing.JButton();
        saveJButton = new javax.swing.JButton();
        backJButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        devicedescriptionJTextArea = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        maintenanceJTextArea = new javax.swing.JTextArea();
        jLabel3 = new javax.swing.JLabel();
        maintenancedueJTextField = new javax.swing.JTextField();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        productNameJLabel.setText("Device Type");
        add(productNameJLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 108, -1, -1));

        priceJLabel.setText(" Price");
        add(priceJLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(213, 139, -1, -1));

        productIDJLabel.setText("Device ID");
        add(productIDJLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(193, 77, -1, -1));

        panelTitleJLabel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        panelTitleJLabel.setText("View Product Details");
        add(panelTitleJLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 20, -1, -1));

        pIDJTextField.setEditable(false);
        pIDJTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pIDJTextFieldActionPerformed(evt);
            }
        });
        add(pIDJTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(265, 74, 202, -1));

        pNameJTextField.setEditable(false);
        add(pNameJTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(265, 105, 202, -1));

        pPriceJTextField.setEditable(false);
        add(pPriceJTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(265, 136, 202, -1));

        updateJButton.setText("Update");
        updateJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateJButtonActionPerformed(evt);
            }
        });
        add(updateJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(297, 380, -1, -1));

        saveJButton.setText("Save");
        saveJButton.setEnabled(false);
        saveJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveJButtonActionPerformed(evt);
            }
        });
        add(saveJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(402, 380, -1, -1));

        backJButton.setText("<<Back");
        backJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backJButtonActionPerformed(evt);
            }
        });
        add(backJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(21, 549, -1, -1));

        jLabel1.setText("Device Description");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(152, 174, -1, -1));

        jLabel2.setText("Maintenance Description");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(123, 248, -1, -1));

        devicedescriptionJTextArea.setEditable(false);
        devicedescriptionJTextArea.setColumns(20);
        devicedescriptionJTextArea.setRows(5);
        jScrollPane1.setViewportView(devicedescriptionJTextArea);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(265, 174, 223, 56));

        maintenanceJTextArea.setEditable(false);
        maintenanceJTextArea.setColumns(20);
        maintenanceJTextArea.setRows(5);
        jScrollPane2.setViewportView(maintenanceJTextArea);

        add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(265, 248, 223, 63));

        jLabel3.setText("Maintenance Due after every (No. of days)");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 330, -1, -1));

        maintenancedueJTextField.setEditable(false);
        add(maintenancedueJTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(265, 329, 223, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void pIDJTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pIDJTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pIDJTextFieldActionPerformed

    private void updateJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateJButtonActionPerformed

        pNameJTextField.setEditable(true);
        pPriceJTextField.setEditable(true);
        devicedescriptionJTextArea.setEditable(true);
        maintenanceJTextArea.setEditable(true);
        maintenancedueJTextField.setEditable(true);
        saveJButton.setEnabled(true);
        updateJButton.setEnabled(false);
    }//GEN-LAST:event_updateJButtonActionPerformed

    private void saveJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveJButtonActionPerformed

        try {
            p.setCost(Integer.parseInt(pPriceJTextField.getText()));
            p.setTypeOfDevice(pNameJTextField.getText());
            p.setDeviceDescription(devicedescriptionJTextArea.getText());
            p.setMaintenanceProcedureDescription(maintenanceJTextArea.getText());
            p.setMaintenanceDueAfter(Integer.parseInt(maintenancedueJTextField.getText()));

            JOptionPane.showMessageDialog(null, "Changes have been updated.");
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Please enter valid values.");
            return;
        }
    }//GEN-LAST:event_saveJButtonActionPerformed

    private void backJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backJButtonActionPerformed

        upc.remove(this);
        CardLayout layout = (CardLayout) upc.getLayout();
        layout.previous(upc);
    }//GEN-LAST:event_backJButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backJButton;
    private javax.swing.JTextArea devicedescriptionJTextArea;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea maintenanceJTextArea;
    private javax.swing.JTextField maintenancedueJTextField;
    private javax.swing.JTextField pIDJTextField;
    private javax.swing.JTextField pNameJTextField;
    private javax.swing.JTextField pPriceJTextField;
    private javax.swing.JLabel panelTitleJLabel;
    private javax.swing.JLabel priceJLabel;
    private javax.swing.JLabel productIDJLabel;
    private javax.swing.JLabel productNameJLabel;
    private javax.swing.JButton saveJButton;
    private javax.swing.JButton updateJButton;
    // End of variables declaration//GEN-END:variables
}