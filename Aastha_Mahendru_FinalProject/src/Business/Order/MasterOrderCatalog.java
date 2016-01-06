/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Order;

import java.util.ArrayList;

/**
 *
 * @author Aastha
 */
public class MasterOrderCatalog {

    private ArrayList<Order> moc;

    public MasterOrderCatalog() {
        moc = new ArrayList<>();
    }

    public ArrayList<Order> getMoc() {
        return moc;
    }

    public void setMoc(ArrayList<Order> moc) {
        this.moc = moc;
    }

    public Order addOrder(Order o) {
        moc.add(o);
        return o;
    }

}
