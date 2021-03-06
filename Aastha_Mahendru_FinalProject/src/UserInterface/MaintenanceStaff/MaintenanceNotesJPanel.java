/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.MaintenanceStaff;

import Business.Employee.MaintenanceEmployee;
import Business.Inventory.DeviceMaintenance;
import Business.Inventory.MaintenanceHistory;
import java.awt.CardLayout;
import java.util.Calendar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Aastha
 */
public class MaintenanceNotesJPanel extends javax.swing.JPanel {

    JPanel upc;
    DeviceMaintenance dm;
    MaintenanceEmployee me;

    /**
     * Creates new form MaintenanceNotesJPanel
     */
    public MaintenanceNotesJPanel(JPanel upc, DeviceMaintenance dm, MaintenanceEmployee me) {
        initComponents();
        this.upc = upc;
        this.dm = dm;
        this.me = me;

        deviceIDJLabel.setText(String.valueOf(dm.getDevice().getInventoryIDNo()));
        deviceNameJLabel.setText(dm.getDevice().getDeviceDetails().getTypeOfDevice());

    }

    public void saveMaintenanceHistory() {

        if (notesJTextArea.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Please enter some details about the maintenance performed for future references.");
            return;
        } else {
            MaintenanceHistory mh = new MaintenanceHistory();
            mh.setLastMaintenanceDate(Calendar.getInstance().getTime());
            mh.setMaintenanceNotes(notesJTextArea.getText());
            mh.setMemp(me);
            dm.getMaintenanceHistory().add(mh);
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

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        notesJTextArea = new javax.swing.JTextArea();
        submitJButton = new javax.swing.JButton();
        deviceIDJLabel = new javax.swing.JLabel();
        deviceNameJLabel = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        backJButton = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Maintenance Notes");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 20, -1, -1));

        jLabel2.setText("Please enter details of the maintenance done for this device (any problems or fixes):");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 450, 20));

        notesJTextArea.setColumns(20);
        notesJTextArea.setRows(5);
        jScrollPane1.setViewportView(notesJTextArea);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 100, 290, 110));

        submitJButton.setText("Submit");
        submitJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitJButtonActionPerformed(evt);
            }
        });
        add(submitJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 230, -1, -1));

        deviceIDJLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        deviceIDJLabel.setText("jLabel3");
        add(deviceIDJLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 70, -1, -1));

        deviceNameJLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        deviceNameJLabel.setText("jLabel4");
        add(deviceNameJLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 70, -1, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Device:");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, -1, -1));

        backJButton.setText("<<Back");
        backJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backJButtonActionPerformed(evt);
            }
        });
        add(backJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 480, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void backJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backJButtonActionPerformed
        upc.remove(this);
        CardLayout layout = (CardLayout) upc.getLayout();
        layout.previous(upc);
    }//GEN-LAST:event_backJButtonActionPerformed

    private void submitJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitJButtonActionPerformed
        saveMaintenanceHistory();
    }//GEN-LAST:event_submitJButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backJButton;
    private javax.swing.JLabel deviceIDJLabel;
    private javax.swing.JLabel deviceNameJLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea notesJTextArea;
    private javax.swing.JButton submitJButton;
    // End of variables declaration//GEN-END:variables
}
