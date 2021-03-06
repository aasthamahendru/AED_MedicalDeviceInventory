/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.Supplier;

import Business.Employee.Supplier;
import Business.Supplier.SDeviceType;
import java.awt.CardLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Aastha
 */
public class ManageProductCatalogJPanel extends javax.swing.JPanel {

    JPanel upc;
    Supplier s;

    /**
     * Creates new form ManageProductCatalogJPanel
     */
    public ManageProductCatalogJPanel(JPanel upc, Supplier s) {
        initComponents();
        this.upc = upc;
        this.s = s;
        sNameJLabel.setText(s.getCompanyName());
        refreshTable();
    }

    private void refreshTable() {
        int rowCount = productCatalog.getRowCount();
        DefaultTableModel model = (DefaultTableModel) productCatalog.getModel();
        for (int i = rowCount - 1; i >= 0; i--) {
            model.removeRow(i);
        }

        for (SDeviceType p : s.getProductCatalog().getSupplierCatalog()) {
            Object row[] = new Object[4];
            row[0] = p;
            row[1] = p.getModelNumber();
            row[2] = p.getCost();
            // row[3] = p.getDevice().getDateofManufacturer();
            model.addRow(row);
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
        productCatalog = new javax.swing.JTable();
        addJButton = new javax.swing.JButton();
        viewJButton = new javax.swing.JButton();
        removeJButton = new javax.swing.JButton();
        sNameJLabel = new javax.swing.JLabel();
        backJButton = new javax.swing.JButton();
        refreshJButton = new javax.swing.JButton();
        panelTitleJLabel = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        productCatalog.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Product Name", "Model No.", "Price"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Integer.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(productCatalog);
        if (productCatalog.getColumnModel().getColumnCount() > 0) {
            productCatalog.getColumnModel().getColumn(0).setResizable(false);
            productCatalog.getColumnModel().getColumn(1).setResizable(false);
            productCatalog.getColumnModel().getColumn(2).setResizable(false);
        }

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 84, 579, 233));

        addJButton.setText("Add New Product");
        addJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addJButtonActionPerformed(evt);
            }
        });
        add(addJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(474, 369, -1, -1));

        viewJButton.setText("View & Update Product Details");
        viewJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewJButtonActionPerformed(evt);
            }
        });
        add(viewJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(99, 335, -1, -1));

        removeJButton.setText("Remove");
        removeJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeJButtonActionPerformed(evt);
            }
        });
        add(removeJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 335, -1, -1));

        sNameJLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        sNameJLabel.setText("jLabel1");
        add(sNameJLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 49, -1, -1));

        backJButton.setText("<<Back");
        backJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backJButtonActionPerformed(evt);
            }
        });
        add(backJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 529, -1, -1));

        refreshJButton.setText("Refresh");
        refreshJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshJButtonActionPerformed(evt);
            }
        });
        add(refreshJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(518, 335, -1, -1));

        panelTitleJLabel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        panelTitleJLabel.setText("Manage Product Catalog");
        add(panelTitleJLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(175, 11, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void viewJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewJButtonActionPerformed
        // TODO add your handling code here:
        int row = productCatalog.getSelectedRow();
        if (row < 0) {
            JOptionPane.showMessageDialog(null, "Please select a product to view.");
            return;
        }
        SDeviceType p = (SDeviceType) productCatalog.getValueAt(row, 0);
        ViewProductDetailsJPanel vpdjp = new ViewProductDetailsJPanel(upc, p);
        upc.add("ViewProductDetailJPanel", vpdjp);
        CardLayout layout = (CardLayout) upc.getLayout();
        layout.next(upc);
    }//GEN-LAST:event_viewJButtonActionPerformed

    private void addJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addJButtonActionPerformed
        // TODO add your handling code here:
        AddProductJPanel apjp = new AddProductJPanel(upc, s);
        upc.add("addProduct", apjp);
        CardLayout layout = (CardLayout) upc.getLayout();
        layout.next(upc);
    }//GEN-LAST:event_addJButtonActionPerformed

    private void removeJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeJButtonActionPerformed
        // TODO add your handling code here:
        int row = productCatalog.getSelectedRow();
        if (row < 0) {
            JOptionPane.showMessageDialog(null, "Please select a product to delete");
            return;
        }
        int result = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete this product?", "Warning", JOptionPane.YES_NO_OPTION);
        if (result == JOptionPane.YES_OPTION) {
            SDeviceType p = (SDeviceType) productCatalog.getValueAt(row, 0);
            s.getProductCatalog().removeProduct(p);
            refreshTable();
        }
    }//GEN-LAST:event_removeJButtonActionPerformed

    private void backJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backJButtonActionPerformed
        // TODO add your handling code here:
        upc.remove(this);
        CardLayout layout = (CardLayout) upc.getLayout();
        layout.previous(upc);
    }//GEN-LAST:event_backJButtonActionPerformed

    private void refreshJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshJButtonActionPerformed

        refreshTable();
    }//GEN-LAST:event_refreshJButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addJButton;
    private javax.swing.JButton backJButton;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel panelTitleJLabel;
    private javax.swing.JTable productCatalog;
    private javax.swing.JButton refreshJButton;
    private javax.swing.JButton removeJButton;
    private javax.swing.JLabel sNameJLabel;
    private javax.swing.JButton viewJButton;
    // End of variables declaration//GEN-END:variables
}
