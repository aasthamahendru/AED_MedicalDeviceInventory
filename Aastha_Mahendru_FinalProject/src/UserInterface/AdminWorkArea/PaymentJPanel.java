/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.AdminWorkArea;

import Business.Employee.WarehouseManager;
import Business.Inventory.Warehouse;
import Business.InventoryRecords.AccountDetails;
import Business.Network.Network;
import Business.Order.Order;
import Business.Order.OrderItem;
import Business.Organization.SupplierOrganization;
import Business.RequestQueue.SupplierOrderRequest;
import Business.UserAccount.UserAccount;
import java.awt.CardLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Aastha
 */
public class PaymentJPanel extends javax.swing.JPanel {

    Order order;
    JPanel upc;
    WarehouseManager manager;
    SupplierOrganization sorg;
    UserAccount ua;
    Warehouse warehouse;
    Network network;
    int amount = 0;

    /**
     * Creates new form PaymentJPanel
     */
    public PaymentJPanel(JPanel upc, Order order, UserAccount ua, SupplierOrganization sorg, Warehouse warehouse, Network network) {
        initComponents();
        this.order = order;
        this.upc = upc;
        this.ua = ua;
        this.sorg = sorg;
        this.warehouse = warehouse;
        this.network = network;

        displayTotalAmount();
    }

    public void displayTotalAmount() {

        for (OrderItem oi : order.getListOfItemsOrdered()) {
            amount = amount + (oi.getQuantity() * oi.getProduct().getCost());
        }

        amountJLabel.setText(String.valueOf(amount));
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
        bankNameJTextField = new javax.swing.JTextField();
        accountNameJTextField = new javax.swing.JTextField();
        routingNoJTextField = new javax.swing.JTextField();
        accountJTextField = new javax.swing.JTextField();
        payJButton = new javax.swing.JButton();
        backJButton = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        amountJLabel = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Enter Payment Details:");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(26, 125, -1, -1));

        jLabel2.setText("Account No.:");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(73, 160, -1, -1));

        jLabel3.setText("Routing No.:");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(75, 198, -1, -1));

        jLabel4.setText("Account Name:");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(63, 236, -1, -1));

        jLabel5.setText("Bank Name:");
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(79, 274, -1, -1));
        add(bankNameJTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(146, 271, 210, -1));
        add(accountNameJTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(146, 233, 210, -1));
        add(routingNoJTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(146, 195, 210, -1));
        add(accountJTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(146, 157, 210, -1));

        payJButton.setText("Pay & Place Order");
        payJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                payJButtonActionPerformed(evt);
            }
        });
        add(payJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(237, 318, -1, -1));

        backJButton.setText("<<Back");
        backJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backJButtonActionPerformed(evt);
            }
        });
        add(backJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(51, 415, -1, -1));

        jLabel6.setText("Total Amount Due:");
        add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(63, 79, -1, -1));

        amountJLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        amountJLabel.setText("jLabel7");
        add(amountJLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 80, -1, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel7.setText("Payment Details");
        add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 19, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void backJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backJButtonActionPerformed
        upc.remove(this);
        CardLayout layout = (CardLayout) upc.getLayout();
        layout.previous(upc);

    }//GEN-LAST:event_backJButtonActionPerformed

    private void payJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_payJButtonActionPerformed
        try {
            String bankName = bankNameJTextField.getText();
            String accountName = accountNameJTextField.getText();
            int accountNo = Integer.parseInt(accountJTextField.getText());
            String routingNo = routingNoJTextField.getText();

            AccountDetails accDetails = new AccountDetails();
            accDetails.setAccountName(accountName);
            accDetails.setAccountNo(accountNo);
            accDetails.setBankName(bankName);
            accDetails.setRoutingNo(routingNo);
            order.setPaymentDetails(accDetails);
            order.setTotalamount(amount);
            order.setSupplier(sorg.getS());
            network.getMoc().addOrder(order);
            order.setStatus("Pending Approval");
            order.setWarehouse(warehouse);

            SupplierOrderRequest sor = new SupplierOrderRequest();
            sor.setOrder(order);
            sor.setSender(ua);

            sorg.getRequestQueue().getWorkRequestList().add(sor);
            JOptionPane.showMessageDialog(null, "Your order has been placed! Thanks!");

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Please enter valid and complete information.");
            return;
        }
    }//GEN-LAST:event_payJButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField accountJTextField;
    private javax.swing.JTextField accountNameJTextField;
    private javax.swing.JLabel amountJLabel;
    private javax.swing.JButton backJButton;
    private javax.swing.JTextField bankNameJTextField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JButton payJButton;
    private javax.swing.JTextField routingNoJTextField;
    // End of variables declaration//GEN-END:variables
}