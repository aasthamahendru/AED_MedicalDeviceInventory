/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.AdminWorkArea;

import Business.Enterprise.InventoryEnterprise;
import Business.Inventory.IDevice;
import Business.Inventory.IDeviceType;
import Business.Inventory.Warehouse;
import Business.Organization.InventoryOrganization;
import Business.Organization.Organization;
import java.awt.CardLayout;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Collections;
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
public class InventoryUsageJPanel extends javax.swing.JPanel {

    JPanel upc;
    InventoryEnterprise inventoryEnterprise;
    InventoryOrganization iorg;
    ArrayList<IDeviceType> typeOfDevicesInInventory;

    /**
     * Creates new form InventoryUsageJPanel
     */
    public InventoryUsageJPanel(JPanel upc, InventoryEnterprise inventoryEnterprise) {
        initComponents();
        this.upc = upc;
        this.inventoryEnterprise = inventoryEnterprise;
        typeOfDevicesInInventory = new ArrayList<>();
        extractInventoryOrganization();
        populateTypeOfDevices();
        calculateDeviceUsage();
        populateTable();
        findTopDevice();
        findLeastUsedDevices();

    }

    public void extractInventoryOrganization() {
        for (Organization org : inventoryEnterprise.getOrganizationDirectory().getOrganizationList()) {
            if (org instanceof InventoryOrganization) {
                iorg = (InventoryOrganization) org;
            }
        }
    }

    public void populateTypeOfDevices() {
        for (Warehouse w : iorg.getWarehouseDirectory().getWarehouseList()) {
            for (IDevice device : w.getListOfDevices().getDeviceList()) {
                IDeviceType idt = device.getDeviceDetails();
                typeOfDevicesInInventory.add(idt);
            }
        }
        Collections.sort(typeOfDevicesInInventory);

        IDeviceType e = new IDeviceType();
        e.setTypeOfDevice("bogus");
        e.setModelNumber(-1);
        e.setDeviceDescription("bogus");
        typeOfDevicesInInventory.add(e);
        ArrayList<IDeviceType> temp = new ArrayList<>();
        int i;
        for (i = 0; i < typeOfDevicesInInventory.size() - 1; i++) {
            if (!typeOfDevicesInInventory.get(i).toString().equals(typeOfDevicesInInventory.get(i + 1).toString())) {
                temp.add(typeOfDevicesInInventory.get(i));
            }
        }
        typeOfDevicesInInventory.clear();
        typeOfDevicesInInventory.addAll(temp);

    }

    public void calculateDeviceUsage() {
        for (Warehouse w : iorg.getWarehouseDirectory().getWarehouseList()) {
            for (IDevice device : w.getListOfDevices().getDeviceList()) {
                int size = device.getReservations().size();
                for (IDeviceType idt : typeOfDevicesInInventory) {
                    if (idt.getTypeOfDevice().equals(device.getDeviceDetails().getTypeOfDevice())) {
                        idt.setNumberOfTimesReserved(idt.getNumberOfTimesReserved() + size);
                    }
                }
            }
        }
    }

    public void populateTable() {
        Collections.sort(typeOfDevicesInInventory, IDeviceType.numberReservedComparator);

        DefaultTableModel dtm = (DefaultTableModel) deviceUsageJTable.getModel();
        dtm.setRowCount(0);
        Object[] row = new Object[2];

        for (IDeviceType idt : typeOfDevicesInInventory) {
            row[0] = idt;
            row[1] = idt.getNumberOfTimesReserved();

            dtm.addRow(row);
        }

    }

    public void findTopDevice() {

        int max = 0;
        int current = 0;
        String currentPName = "null";
        ArrayList<String> currentPList = new ArrayList<>();
        currentPList.add("null");
        DefaultTableModel dtm = (DefaultTableModel) deviceUsageJTable.getModel();

        for (int i = 0; i < dtm.getRowCount(); i++) {
            current = (int) dtm.getValueAt(i, 1);
            if (max < current) {
                max = current;
                IDeviceType dt = (IDeviceType) dtm.getValueAt(i, 0);
                currentPName = dt.getTypeOfDevice();
                currentPList.clear();
                currentPList.add(currentPName);
            } else if (max == current) {
                IDeviceType dt = (IDeviceType) dtm.getValueAt(i, 0);
                currentPName = dt.getTypeOfDevice();
                currentPList.add(currentPName);
            }
        }
        mostUsedLabel.setText(currentPList.toString());
    }

    public void findLeastUsedDevices() {
        int min = 0;
        int current = 0;
        String currentPName = "null";
        ArrayList<String> currentPList = new ArrayList<>();
        currentPList.add("null");
        DefaultTableModel dtm = (DefaultTableModel) deviceUsageJTable.getModel();
        min = (int) dtm.getValueAt(0, 1);
        for (int i = 0; i < dtm.getRowCount(); i++) {
            current = (int) dtm.getValueAt(i, 1);
            if (min > current) {
                min = current;
                IDeviceType dt = (IDeviceType) dtm.getValueAt(i, 0);
                currentPName = dt.getTypeOfDevice();
                currentPList.clear();
                currentPList.add(currentPName);
            } else if (min == current) {
                IDeviceType dt = (IDeviceType) dtm.getValueAt(i, 0);
                currentPName = dt.getTypeOfDevice();
                currentPList.add(currentPName);
            }
        }
        leastUsedLabel.setText(currentPList.toString());
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
        usageJButton = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        mostUsedLabel = new javax.swing.JLabel();
        leastUsedLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        deviceUsageJTable = new javax.swing.JTable();
        backJButton = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Inventory Usage");

        usageJButton.setText("View Device Usage>>");
        usageJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usageJButtonActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("Most Used Device:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("Least Used Device:");

        mostUsedLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        mostUsedLabel.setText("jLabel4");

        leastUsedLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        leastUsedLabel.setText("jLabel5");

        deviceUsageJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Device Type", "Number of Reservations"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(deviceUsageJTable);
        if (deviceUsageJTable.getColumnModel().getColumnCount() > 0) {
            deviceUsageJTable.getColumnModel().getColumn(0).setResizable(false);
            deviceUsageJTable.getColumnModel().getColumn(1).setResizable(false);
        }

        backJButton.setText("<<Back");
        backJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backJButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(238, 238, 238)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(mostUsedLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 475, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(18, 18, 18)
                                .addComponent(leastUsedLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(255, 255, 255)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(181, 181, 181)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 336, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(288, 288, 288)
                        .addComponent(usageJButton))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addComponent(backJButton)))
                .addContainerGap(41, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(mostUsedLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(leastUsedLabel))
                .addGap(38, 38, 38)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 182, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(usageJButton)
                .addGap(189, 189, 189)
                .addComponent(backJButton)
                .addGap(25, 25, 25))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void usageJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usageJButtonActionPerformed
        DefaultTableModel dtm = (DefaultTableModel) deviceUsageJTable.getModel();
        int rows = dtm.getRowCount();

        DefaultCategoryDataset dataSet = new DefaultCategoryDataset();

        for (int i = 0; i < rows; i++) {
            int num = (int) deviceUsageJTable.getValueAt(i, 1);
            dataSet.setValue(num, "Number Of Reservations", String.valueOf(deviceUsageJTable.getValueAt(i, 0)));
        }

        JFreeChart chart = ChartFactory.createBarChart("Device Usage Chart", "Device Name", "Number of Reservations", dataSet, PlotOrientation.VERTICAL, false, true, false);
        CategoryPlot plot = chart.getCategoryPlot();
        plot.setRangeGridlinePaint(Color.BLACK);

        ChartFrame frame = new ChartFrame("Sales Overview", chart);
        frame.setVisible(true);
        frame.setSize(600, 600);
    }//GEN-LAST:event_usageJButtonActionPerformed

    private void backJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backJButtonActionPerformed
        upc.remove(this);
        CardLayout layout = (CardLayout) upc.getLayout();
        layout.previous(upc);
    }//GEN-LAST:event_backJButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backJButton;
    private javax.swing.JTable deviceUsageJTable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel leastUsedLabel;
    private javax.swing.JLabel mostUsedLabel;
    private javax.swing.JButton usageJButton;
    // End of variables declaration//GEN-END:variables
}
