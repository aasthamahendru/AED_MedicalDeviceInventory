
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.AdminWorkArea;

import Business.Employee.Supplier;
import Business.Supplier.SDeviceType;
import java.awt.CardLayout;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Aastha
 */
public class ViewSJPanel extends javax.swing.JPanel {

    JPanel upc;
    Supplier s;

    /**
     * Creates new form ViewSJPanel
     */
    public ViewSJPanel(JPanel upc, Supplier s) {
        initComponents();
        this.upc = upc;
        this.s = s;
        SNameJLabel.setText(this.s.getCompanyName());
        refreshTable();
    }

    private void refreshTable() {
        int rowCount = productCatalog.getRowCount();
        DefaultTableModel model = (DefaultTableModel) productCatalog.getModel();
        for (int i = rowCount - 1; i >= 0; i--) {
            model.removeRow(i);
        }

        for (SDeviceType p : s.getProductCatalog().getSupplierCatalog()) {
            Object[] row = new Object[3];
            row[0] = p;
            row[1] = p.getModelNumber();
            // row[1] = p.getDevice().getDeviceID();
            row[2] = p.getCost();
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
        SNameJLabel = new javax.swing.JLabel();
        backJButton = new javax.swing.JButton();
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

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 84, 584, 285));

        SNameJLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        SNameJLabel.setText("jLabel1");
        add(SNameJLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 56, 96, -1));

        backJButton.setText("<<Back");
        backJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backJButtonActionPerformed(evt);
            }
        });
        add(backJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 530, -1, -1));

        panelTitleJLabel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        panelTitleJLabel.setText("View Supplier Details");
        add(panelTitleJLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(221, 16, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void backJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backJButtonActionPerformed

        upc.remove(this);
        CardLayout layout = (CardLayout) upc.getLayout();
        layout.previous(upc);
    }//GEN-LAST:event_backJButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel SNameJLabel;
    private javax.swing.JButton backJButton;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel panelTitleJLabel;
    private javax.swing.JTable productCatalog;
    // End of variables declaration//GEN-END:variables
}
