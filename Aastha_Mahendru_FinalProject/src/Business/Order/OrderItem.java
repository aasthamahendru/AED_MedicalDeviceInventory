/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Order;

import Business.Supplier.SDeviceType;

/**
 *
 * @author Aastha
 */
public class OrderItem {

    private SDeviceType product;
    int quantity;

    public SDeviceType getProduct() {
        return product;
    }

    public void setProduct(SDeviceType product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return product.getTypeOfDevice();
    }
}
