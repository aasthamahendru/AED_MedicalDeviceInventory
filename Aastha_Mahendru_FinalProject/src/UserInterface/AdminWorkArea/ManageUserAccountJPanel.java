/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.AdminWorkArea;

import Business.Enterprise.Enterprise;
import Business.Network.Network;
import Business.Organization.Organization;
import Business.Organization.OrganizationDirectory;
import Business.UserAccount.UserAccount;
import java.awt.CardLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Aastha
 */
public class ManageUserAccountJPanel extends javax.swing.JPanel {

    JPanel upc;
    private OrganizationDirectory organizationDirectory;
    private Organization organization;
    private Network network;

    /**
     * Creates new form ManageUserAccountJPanel
     */
    public ManageUserAccountJPanel(JPanel upc, Network network) {
        initComponents();
        this.upc = upc;
        this.network = network;

        populateEntComboBox();
    }

    public void populateEntComboBox() {
        enterpriseJComboBox.removeAllItems();
        for (Enterprise e : network.getEnterpriseDirectory().getEnterpriseList()) {
            enterpriseJComboBox.addItem(e);
        }
        populateTable((Enterprise) enterpriseJComboBox.getSelectedItem());
    }

    public void populateTable(Enterprise e) {
        DefaultTableModel dtm = (DefaultTableModel) userAccountJTable.getModel();
        dtm.setRowCount(0);

        for (Organization org : e.getOrganizationDirectory().getOrganizationList()) {
            for (UserAccount ua : org.getUserAccountDirectory().getUserAccountList()) {
                Object row[] = new Object[4];
                row[0] = ua;
                row[1] = ua.getPassword();
                row[2] = ua.getRole();
                row[3] = ua.getStatus();

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

        manageUserAccountJLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        userAccountJTable = new javax.swing.JTable();
        backjButton2 = new javax.swing.JButton();
        removeJButton = new javax.swing.JButton();
        addJButton = new javax.swing.JButton();
        enterpriseJComboBox = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        changeStatusJButton = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        manageUserAccountJLabel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        manageUserAccountJLabel.setText("Manage User Accounts");
        add(manageUserAccountJLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 10, -1, -1));

        userAccountJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "UserName", "Password", "Role", "Status"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(userAccountJTable);
        if (userAccountJTable.getColumnModel().getColumnCount() > 0) {
            userAccountJTable.getColumnModel().getColumn(0).setResizable(false);
            userAccountJTable.getColumnModel().getColumn(1).setResizable(false);
            userAccountJTable.getColumnModel().getColumn(2).setResizable(false);
            userAccountJTable.getColumnModel().getColumn(3).setResizable(false);
        }

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 95, 760, 93));

        backjButton2.setText("<<Back");
        backjButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backjButton2ActionPerformed(evt);
            }
        });
        add(backjButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 460, -1, -1));

        removeJButton.setText("Remove");
        removeJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeJButtonActionPerformed(evt);
            }
        });
        add(removeJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, -1, -1));

        addJButton.setText("Add User Account>>");
        addJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addJButtonActionPerformed(evt);
            }
        });
        add(addJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 210, -1, -1));

        enterpriseJComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                enterpriseJComboBoxActionPerformed(evt);
            }
        });
        add(enterpriseJComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(78, 57, 210, -1));

        jLabel1.setText("Enterprise");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(19, 60, -1, -1));

        changeStatusJButton.setText("Disable/Activate Account");
        changeStatusJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                changeStatusJButtonActionPerformed(evt);
            }
        });
        add(changeStatusJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 210, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void backjButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backjButton2ActionPerformed
        // TODO add your handling code here:
        upc.remove(this);
        CardLayout layout = (CardLayout) upc.getLayout();
        layout.previous(upc);
    }//GEN-LAST:event_backjButton2ActionPerformed

    private void removeJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeJButtonActionPerformed
        int selectedRow = userAccountJTable.getSelectedRow();

        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(null, "Please select a row!");
            return;
        }
        int result = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete this user account?", "Warning", JOptionPane.YES_NO_OPTION);
        if (result == JOptionPane.YES_OPTION) {
            Enterprise ent = (Enterprise) enterpriseJComboBox.getSelectedItem();
            for (Organization org : ent.getOrganizationDirectory().getOrganizationList()) {
                UserAccount userAccount = (UserAccount) userAccountJTable.getValueAt(selectedRow, 0);
                org.getUserAccountDirectory().removeUserAccount(userAccount);
                populateTable(ent);
            }
        }
    }//GEN-LAST:event_removeJButtonActionPerformed

    private void addJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addJButtonActionPerformed

        AddUserAccount panel = new AddUserAccount(upc, network);
        upc.add("AddUserAccount", panel);
        CardLayout layout = (CardLayout) upc.getLayout();
        layout.next(upc);
    }//GEN-LAST:event_addJButtonActionPerformed

    private void enterpriseJComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_enterpriseJComboBoxActionPerformed
        populateTable((Enterprise) enterpriseJComboBox.getSelectedItem());

    }//GEN-LAST:event_enterpriseJComboBoxActionPerformed

    private void changeStatusJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_changeStatusJButtonActionPerformed
        int selectedRow = userAccountJTable.getSelectedRow();

        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(null, "Please select a row!");
            return;
        }
        Enterprise ent = (Enterprise) enterpriseJComboBox.getSelectedItem();
        for (Organization org : ent.getOrganizationDirectory().getOrganizationList()) {
            UserAccount userAccount = (UserAccount) userAccountJTable.getValueAt(selectedRow, 0);
            org.getUserAccountDirectory().changeStatus(userAccount);
            populateTable(ent);
        }

    }//GEN-LAST:event_changeStatusJButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addJButton;
    private javax.swing.JButton backjButton2;
    private javax.swing.JButton changeStatusJButton;
    private javax.swing.JComboBox enterpriseJComboBox;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel manageUserAccountJLabel;
    private javax.swing.JButton removeJButton;
    private javax.swing.JTable userAccountJTable;
    // End of variables declaration//GEN-END:variables
}