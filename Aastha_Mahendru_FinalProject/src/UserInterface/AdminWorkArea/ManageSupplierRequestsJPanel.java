/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.AdminWorkArea;

import Business.Enterprise.Enterprise;
import Business.Enterprise.InventoryEnterprise;
import Business.Network.Network;
import Business.Organization.AdminOrganization;
import Business.Organization.Organization;
import Business.RequestQueue.Request;
import Business.RequestQueue.SupplierEnrollmentRequest;
import Business.UserAccount.UserAccount;
import java.awt.CardLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Aastha
 */
public class ManageSupplierRequestsJPanel extends javax.swing.JPanel {

    JPanel upc;
    Network n;
    AdminOrganization aorg;
    UserAccount adminAccount;

    /**
     * Creates new form ManageSupplierRequestsJPanel
     */
    public ManageSupplierRequestsJPanel(JPanel upc, Network n, UserAccount adminAccount) {
        initComponents();
        this.upc = upc;
        this.n = n;
        this.adminAccount = adminAccount;
        for (Enterprise e : n.getEnterpriseDirectory().getEnterpriseList()) {
            if (e instanceof InventoryEnterprise) {
                for (Organization organization : e.getOrganizationDirectory().getOrganizationList()) {
                    if (organization instanceof AdminOrganization) {
                        this.aorg = (AdminOrganization) organization;
                    }
                }
            }
        }

        populateTable();

    }

    public void populateTable() {
        DefaultTableModel dtm = (DefaultTableModel) supplierRequestJTable.getModel();
        dtm.setRowCount(0);

        for (Request req : aorg.getRequestQueue().getWorkRequestList()) {
            if (req instanceof SupplierEnrollmentRequest) {
                SupplierEnrollmentRequest sreq = (SupplierEnrollmentRequest) req;

                Object[] row = new Object[4];
                row[0] = req;
                row[1] = req.getSender().getEmployee().getFirstName() + " " + req.getSender().getEmployee().getLastName();
                //String name = req.getReceiver().getEmployee().getFirstName()+" "+req.getReceiver().getEmployee().getLastName();
                row[2] = req.getReceiver() == null ? null : req.getReceiver().getEmployee().getFirstName() + " " + req.getReceiver().getEmployee().getLastName();;
                row[3] = req.getStatus();
                dtm.addRow(row);
            }
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

        jScrollPane1 = new javax.swing.JScrollPane();
        supplierRequestJTable = new javax.swing.JTable();
        refreshJButton = new javax.swing.JButton();
        processJButton = new javax.swing.JButton();
        backButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        supplierRequestJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Message", "Sender", "Receiver", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(supplierRequestJTable);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(73, 81, 630, 240));

        refreshJButton.setText("Refresh");
        refreshJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshJButtonActionPerformed(evt);
            }
        });
        add(refreshJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 330, -1, -1));

        processJButton.setText("Process");
        processJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                processJButtonActionPerformed(evt);
            }
        });
        add(processJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 330, -1, -1));

        backButton.setText("<<Back");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });
        add(backButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 510, -1, -1));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Supplier Requests");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 30, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void refreshJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshJButtonActionPerformed
        populateTable();
    }//GEN-LAST:event_refreshJButtonActionPerformed

    private void processJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_processJButtonActionPerformed
        int selectedRow = supplierRequestJTable.getSelectedRow();
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(null, "Please select a row.");
            return;
        }
        SupplierEnrollmentRequest req = (SupplierEnrollmentRequest) supplierRequestJTable.getValueAt(selectedRow, 0);
        req.setStatus("Processing");
        req.setReceiver(adminAccount);
        populateTable();

        ProcessSupplierRequest psr = new ProcessSupplierRequest(upc, req);
        upc.add("processRequest", psr);
        CardLayout l = (CardLayout) upc.getLayout();
        l.next(upc);
    }//GEN-LAST:event_processJButtonActionPerformed

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        upc.remove(this);
        CardLayout layout = (CardLayout) upc.getLayout();
        layout.previous(upc);
    }//GEN-LAST:event_backButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton processJButton;
    private javax.swing.JButton refreshJButton;
    private javax.swing.JTable supplierRequestJTable;
    // End of variables declaration//GEN-END:variables
}
