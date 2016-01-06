/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.Supplier;

import Business.Employee.Supplier;
import Business.Order.MasterOrderCatalog;
import Business.Order.Order;
import Business.Order.OrderItem;
import java.awt.CardLayout;
import java.awt.Color;
import java.util.ArrayList;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 *
 * @author Aastha
 */
public class SalesOverviewJPanel extends javax.swing.JPanel {

    JPanel upc;
    Supplier s;
    MasterOrderCatalog moc;
    int totalsale = 0;
    int totalamount = 0;

    /**
     * Creates new form SalesOverviewJPanel
     */
    public SalesOverviewJPanel(JPanel upc, Supplier s, MasterOrderCatalog moc) {
        initComponents();
        this.upc = upc;
        this.s = s;
        this.moc = moc;
        calculatePerformance();
        populateTable();
        findTopProduct();
    }

    private void findTopProduct() {
        int max = 0;
        int current = 0;
        String currentPName = "null";
        ArrayList<String> currentPList = new ArrayList<>();
        currentPList.add("null");
        DefaultTableModel dtm = (DefaultTableModel) performanceJTable.getModel();
        for (int i = 0; i < dtm.getRowCount(); i++) {
            current = (int) dtm.getValueAt(i, 1);
            if (max < current) {
                max = current;
                currentPName = (String) dtm.getValueAt(i, 0);
                currentPList.clear();
                currentPList.add(currentPName);
            } else if (max == current) {
                currentPName = (String) dtm.getValueAt(i, 0);
                currentPList.add(currentPName);
            }
        }
        topSellingJLabel.setText(currentPList.toString());

    }

    private void calculatePerformance() {
        for (Order o : moc.getMoc()) {
            if (o.getSupplier().getCompanyName().equals(s.getCompanyName())) {
                for (OrderItem oi : o.getListOfItemsOrdered()) {
                    totalsale = totalsale + oi.getQuantity();       //determining number of items sold for this supplier.
                    totalamount = totalamount + (oi.getProduct().getCost() * oi.getQuantity());
                }

            }

        }

        productsSoldJLabel.setText(String.valueOf(totalsale));
        salesAmountJLabel.setText(String.valueOf(totalamount));
    }

    public void populateTable() {
        DefaultTableModel dtm = (DefaultTableModel) performanceJTable.getModel();
        dtm.setRowCount(0);
        Object[] obj = new Object[3];
        ArrayList<String> temp = new ArrayList<>();
        for (Order o : moc.getMoc()) {
            if (o.getSupplier().getCompanyName().equals(s.getCompanyName())) {
                for (OrderItem oi : o.getListOfItemsOrdered()) {
                    if (!temp.contains(oi.getProduct().getTypeOfDevice())) {
                        obj[0] = oi.getProduct().getTypeOfDevice();
                        obj[1] = oi.getQuantity();
                        obj[2] = oi.getProduct().getCost() * oi.getQuantity();
                        dtm.addRow(obj);
                        temp.add(oi.getProduct().getTypeOfDevice());
                    } else if (temp.contains(oi.getProduct().getTypeOfDevice())) {
                        for (int i = 0; i < dtm.getRowCount(); i++) {
                            String prodname = (String) dtm.getValueAt(i, 0);
                            if (prodname.equals(oi.getProduct().getTypeOfDevice())) {
                                int q = (int) dtm.getValueAt(i, 1) + oi.getQuantity();
                                int sale = q * oi.getProduct().getCost();
                                dtm.setValueAt(q, i, 1);
                                dtm.setValueAt(sale, i, 2);

                            }

                        }
                    }
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

        backJButton = new javax.swing.JButton();
        prodSoldJLabel = new javax.swing.JLabel();
        amountJLabel = new javax.swing.JLabel();
        productsSoldJLabel = new javax.swing.JLabel();
        salesAmountJLabel = new javax.swing.JLabel();
        topProdJLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        performanceJTable = new javax.swing.JTable();
        viewGraphJButton = new javax.swing.JButton();
        panelTitleJLabel = new javax.swing.JLabel();
        topSellingJLabel = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        backJButton.setText("<<Back");
        backJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backJButtonActionPerformed(evt);
            }
        });
        add(backJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 510, -1, -1));

        prodSoldJLabel.setText("Total Products sold:");
        add(prodSoldJLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(112, 49, -1, -1));

        amountJLabel.setText("Total Sales amount:");
        add(amountJLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(112, 74, -1, -1));
        add(productsSoldJLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(239, 49, -1, -1));
        add(salesAmountJLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(239, 74, -1, -1));

        topProdJLabel.setText("Top Selling Product(s):");
        add(topProdJLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(112, 99, -1, -1));

        performanceJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Product", "Quantity", "Total Sale Amount"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class
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
        jScrollPane1.setViewportView(performanceJTable);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(42, 131, 338, 170));

        viewGraphJButton.setText("View Bar Chart");
        viewGraphJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewGraphJButtonActionPerformed(evt);
            }
        });
        add(viewGraphJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 310, -1, -1));

        panelTitleJLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        panelTitleJLabel.setText("Sales Overview");
        add(panelTitleJLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(143, 11, -1, -1));
        add(topSellingJLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(238, 99, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void backJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backJButtonActionPerformed

        upc.remove(this);
        CardLayout layout = (CardLayout) upc.getLayout();
        layout.previous(upc);
    }//GEN-LAST:event_backJButtonActionPerformed

    private void viewGraphJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewGraphJButtonActionPerformed
        DefaultTableModel dtm = (DefaultTableModel) performanceJTable.getModel();
        int rows = dtm.getRowCount();

        DefaultCategoryDataset dataSet = new DefaultCategoryDataset();

        for (int i = 0; i < rows; i++) {
            int quant = (int) performanceJTable.getValueAt(i, 1);
            dataSet.setValue(quant, "QuantitySold", (String) performanceJTable.getValueAt(i, 0));
        }

        JFreeChart chart = ChartFactory.createBarChart("Sales Performance Chart", "Product Name", "Quantity Sold", dataSet, PlotOrientation.VERTICAL, false, true, false);
        CategoryPlot plot = chart.getCategoryPlot();
        plot.setRangeGridlinePaint(Color.BLACK);

        ChartFrame frame = new ChartFrame("Sales Overview", chart);
        frame.setVisible(true);
        frame.setSize(600, 600);

    }//GEN-LAST:event_viewGraphJButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel amountJLabel;
    private javax.swing.JButton backJButton;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel panelTitleJLabel;
    private javax.swing.JTable performanceJTable;
    private javax.swing.JLabel prodSoldJLabel;
    private javax.swing.JLabel productsSoldJLabel;
    private javax.swing.JLabel salesAmountJLabel;
    private javax.swing.JLabel topProdJLabel;
    private javax.swing.JLabel topSellingJLabel;
    private javax.swing.JButton viewGraphJButton;
    // End of variables declaration//GEN-END:variables
}