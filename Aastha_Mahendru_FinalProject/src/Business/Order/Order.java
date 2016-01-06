/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Order;

import Business.Employee.Supplier;
import Business.Inventory.Warehouse;
import Business.InventoryRecords.AccountDetails;
import Business.Supplier.SDeviceType;
import java.util.ArrayList;

/**
 *
 * @author Aastha
 */
public class Order {

    private ArrayList<OrderItem> listOfItemsOrdered;
    static int count = 0;
    int orderID;
    String status;
    Warehouse warehouse;
    AccountDetails paymentDetails;
    int totalamount;
    Supplier supplier;

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

    public int getTotalamount() {
        return totalamount;
    }

    public void setTotalamount(int totalamount) {
        this.totalamount = totalamount;
    }

    public AccountDetails getPaymentDetails() {
        return paymentDetails;
    }

    public void setPaymentDetails(AccountDetails paymentDetails) {
        this.paymentDetails = paymentDetails;
    }

    public Warehouse getWarehouse() {
        return warehouse;
    }

    public void setWarehouse(Warehouse warehouse) {
        this.warehouse = warehouse;
    }

    public Order() {
        count++;
        orderID = count;
        listOfItemsOrdered = new ArrayList<>();
    }

    public ArrayList<OrderItem> getListOfItemsOrdered() {
        return listOfItemsOrdered;
    }

    public void setListOfItemsOrdered(ArrayList<OrderItem> listOfItemsOrdered) {
        this.listOfItemsOrdered = listOfItemsOrdered;
    }

    public static int getCount() {
        return count;
    }

    public static void setCount(int count) {
        Order.count = count;
    }

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int OrderID) {
        this.orderID = OrderID;
    }

    public void addOrderItem(SDeviceType p, int quantity) {
        OrderItem orderItem = new OrderItem();
        orderItem.setProduct(p);
        orderItem.setQuantity(quantity);
        listOfItemsOrdered.add(orderItem);
        //return orderItem;
    }
    /*public OrderItem addOrderItem(SDeviceType p, int quantity) {
     OrderItem orderItem = new OrderItem();
     orderItem.setProduct(p);
     orderItem.setQuantity(quantity);
     listOfItemsOrdered.add(orderItem);
     return orderItem;
     }*/

    public void removeOrderItem(OrderItem oi) {
        listOfItemsOrdered.remove(oi);
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return String.valueOf(orderID);
    }

}
