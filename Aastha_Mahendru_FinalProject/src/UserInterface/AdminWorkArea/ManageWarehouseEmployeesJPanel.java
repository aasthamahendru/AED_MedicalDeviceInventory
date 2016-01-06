
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.AdminWorkArea;

import Business.Employee.Employee;
import Business.Employee.MaintenanceEmployee;
import Business.Employee.WarehouseManager;
import Business.Enterprise.InventoryEnterprise;
import Business.Inventory.Warehouse;
import Business.Organization.InventoryOrganization;
import Business.Organization.MaintenanceOrganization;
import Business.Organization.Organization;
import Business.Organization.OrganizationDirectory;
import Business.Role.MaintenanceEmployeeRole;
import Business.Role.Role;
import Business.Role.WarehouseManagerRole;
import java.awt.CardLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Aastha
 */
public class ManageWarehouseEmployeesJPanel extends javax.swing.JPanel {

    JPanel upc;
    InventoryEnterprise inventoryEnterprise;
    Warehouse warehouse;
    InventoryOrganization iorg;
    MaintenanceOrganization morg;
    WarehouseManager wm;
    MaintenanceEmployee m;

    /**
     * Creates new form ManageWarehouseEmployeesJPanel
     */
    public ManageWarehouseEmployeesJPanel(JPanel upc, InventoryEnterprise inventoryEnterprise, Warehouse warehouse) {
        initComponents();
        this.upc = upc;
        this.inventoryEnterprise = inventoryEnterprise;
        this.warehouse = warehouse;
        jLabel1.setText(warehouse.getWarehouseName());
        populateRoleComboBoxes();
    }

    public void populateRoleComboBoxes() {
        OrganizationDirectory od = inventoryEnterprise.getOrganizationDirectory();
        for (Organization o : od.getOrganizationList()) {
            if (o instanceof InventoryOrganization) {
                iorg = (InventoryOrganization) o;
                for (Role role : o.getSupportedRole()) {
                    roleJComboBox.addItem(role);
                    roleJComboBox2.addItem(role);
                }

            } else if (o instanceof MaintenanceOrganization) {
                morg = (MaintenanceOrganization) o;

                for (Role role : o.getSupportedRole()) {
                    roleJComboBox.addItem(role);
                    roleJComboBox2.addItem(role);
                }

            }

        }
    }

    public void populateTable(Role role) {
        DefaultTableModel dtm = (DefaultTableModel) employeesJTable.getModel();
        dtm.setRowCount(0);

        Object[] row = new Object[4];

        if (role instanceof WarehouseManagerRole) {
            for (Employee emp : iorg.getEmployeeDirectory().getEmployeeList()) {
                wm = (WarehouseManager) emp;
                if (wm.getWarehouse() == warehouse) {
                    row[0] = wm.getId();
                    row[1] = wm;
                    row[2] = wm.getContactNo();
                    row[3] = wm.getAddress();

                    dtm.addRow(row);
                }
            }

        }
        if (role instanceof MaintenanceEmployeeRole) {
            for (Employee emp : morg.getEmployeeDirectory().getEmployeeList()) {
                m = (MaintenanceEmployee) emp;
                if (m.getWarehouse() == warehouse) {
                    row[0] = m.getId();
                    row[1] = m;
                    row[2] = m.getContactNo();
                    row[3] = m.getAddress();

                    dtm.addRow(row);
                }
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

        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        employeesJTable = new javax.swing.JTable();
        lnameJTextField = new javax.swing.JTextField();
        removeJButton = new javax.swing.JButton();
        fnameJTextField = new javax.swing.JTextField();
        refreshJButton = new javax.swing.JButton();
        roleJComboBox2 = new javax.swing.JComboBox();
        addJButton = new javax.swing.JButton();
        backJButton = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        roleJComboBox = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        contactnoJTextField = new javax.swing.JTextField();
        addressJTextField = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel10 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("Add New Employee:");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 290, -1, -1));

        jLabel5.setText("Select Role:");
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 320, -1, -1));

        jLabel7.setText("Enter Employee First Name:");
        add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 350, -1, -1));

        jLabel8.setText("Enter Employee Last Name:");
        add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 380, -1, -1));

        employeesJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Employee ID", "Employee Name", "Contact No.", "Home Address"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(employeesJTable);
        if (employeesJTable.getColumnModel().getColumnCount() > 0) {
            employeesJTable.getColumnModel().getColumn(0).setResizable(false);
            employeesJTable.getColumnModel().getColumn(1).setResizable(false);
            employeesJTable.getColumnModel().getColumn(2).setResizable(false);
            employeesJTable.getColumnModel().getColumn(3).setResizable(false);
        }

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, 740, 98));
        add(lnameJTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 380, 501, -1));

        removeJButton.setText("Remove");
        removeJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeJButtonActionPerformed(evt);
            }
        });
        add(removeJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 220, -1, -1));
        add(fnameJTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 350, 500, -1));

        refreshJButton.setText("Refresh");
        refreshJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshJButtonActionPerformed(evt);
            }
        });
        add(refreshJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 220, -1, -1));

        roleJComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                roleJComboBox2ActionPerformed(evt);
            }
        });
        add(roleJComboBox2, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 310, 330, -1));

        addJButton.setText("Add Employee");
        addJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addJButtonActionPerformed(evt);
            }
        });
        add(addJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 480, -1, -1));

        backJButton.setText("<< Back");
        backJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backJButtonActionPerformed(evt);
            }
        });
        add(backJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(19, 517, -1, -1));

        jLabel2.setText("Select Role of Employee:");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, -1, -1));

        roleJComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                roleJComboBoxActionPerformed(evt);
            }
        });
        add(roleJComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 72, 320, -1));

        jLabel3.setText("Contact No.:");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 410, -1, -1));

        jLabel6.setText("Home Address:");
        add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 440, -1, -1));
        add(contactnoJTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 410, 501, -1));
        add(addressJTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 440, 501, -1));
        add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 260, 700, 10));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel10.setText("Manage Warehouse Employees for ");
        add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 20, -1, -1));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("jLabel1");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 20, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void removeJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeJButtonActionPerformed
        int selectedRow = employeesJTable.getSelectedRow();
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(null, "Please select a row.");
            return;
        }
        int result = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete this employee?", "Warning", JOptionPane.YES_NO_OPTION);
        if (result == JOptionPane.YES_OPTION) {
            Role role = (Role) roleJComboBox.getSelectedItem();

            Employee e = (Employee) employeesJTable.getValueAt(selectedRow, 1);

            if (role instanceof WarehouseManagerRole) {
                iorg.getEmployeeDirectory().removeEmployee(e);
            }

            if (role instanceof MaintenanceEmployeeRole) {
                morg.getEmployeeDirectory().removeEmployee(e);
            }
        }
    }//GEN-LAST:event_removeJButtonActionPerformed

    private void refreshJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshJButtonActionPerformed
        Role role = (Role) roleJComboBox.getSelectedItem();
        populateTable(role);

    }//GEN-LAST:event_refreshJButtonActionPerformed

    private void addJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addJButtonActionPerformed
        try {
            String firstName = fnameJTextField.getText();
            String lastName = lnameJTextField.getText();
            Role role = (Role) roleJComboBox2.getSelectedItem();
            long contactno = Long.parseLong(contactnoJTextField.getText());
            String address = addressJTextField.getText();

            if (role instanceof WarehouseManagerRole) {
                WarehouseManager w = new WarehouseManager();
                w.setAddress(address);
                w.setContactNo(contactno);
                w.setFirstName(firstName);
                w.setLastName(lastName);
                w.setWarehouse(warehouse);
                iorg.getEmployeeDirectory().getEmployeeList().add(w);

            }

            if (role instanceof MaintenanceEmployeeRole) {

                MaintenanceEmployee me = new MaintenanceEmployee();
                me.setWarehouse(warehouse);
                me.setAddress(address);
                me.setContactNo(contactno);
                me.setFirstName(firstName);
                me.setLastName(lastName);
                morg.getEmployeeDirectory().getEmployeeList().add(me);
            }
            JOptionPane.showMessageDialog(null, "Employee added successfully.");
            populateTable(role);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Please Enter Valid Information.");
            return;
        }

    }//GEN-LAST:event_addJButtonActionPerformed

    private void backJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backJButtonActionPerformed

        upc.remove(this);
        CardLayout layout = (CardLayout) upc.getLayout();
        layout.previous(upc);

    }//GEN-LAST:event_backJButtonActionPerformed

    private void roleJComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_roleJComboBoxActionPerformed
        Role role = (Role) roleJComboBox.getSelectedItem();
        populateTable(role);

    }//GEN-LAST:event_roleJComboBoxActionPerformed

    private void roleJComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_roleJComboBox2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_roleJComboBox2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addJButton;
    private javax.swing.JTextField addressJTextField;
    private javax.swing.JButton backJButton;
    private javax.swing.JTextField contactnoJTextField;
    private javax.swing.JTable employeesJTable;
    private javax.swing.JTextField fnameJTextField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField lnameJTextField;
    private javax.swing.JButton refreshJButton;
    private javax.swing.JButton removeJButton;
    private javax.swing.JComboBox roleJComboBox;
    private javax.swing.JComboBox roleJComboBox2;
    // End of variables declaration//GEN-END:variables
}