/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Employee;

import Business.Inventory.Warehouse;

/**
 *
 * @author Aastha
 */
public class WarehouseManager extends Employee {

    Warehouse warehouse;

    public Warehouse getWarehouse() {
        return warehouse;
    }

    public void setWarehouse(Warehouse warehouse) {
        this.warehouse = warehouse;
    }

    public static int getCount() {
        return count;
    }

    public static void setCount(int count) {
        Employee.count = count;
    }

    @Override
    public String toString() {
        return super.getFirstName() + " " + super.getLastName();
    }
}
