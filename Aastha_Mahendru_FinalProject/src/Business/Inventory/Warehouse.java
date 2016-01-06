/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Inventory;

import Business.Employee.WarehouseManager;

/**
 *
 * @author Aastha
 */
public class Warehouse {

    String address;
    String warehouseName;
    InventoryCatalog listOfDevices;
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    static int count = 1;

    public Warehouse() {
        id = count;
        count++;
        listOfDevices = new InventoryCatalog();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    /* public WarehouseManager getManager() {
     return manager;
     }

     public void setManager(WarehouseManager manager) {
     this.manager = manager;
     }*/

    public InventoryCatalog getListOfDevices() {
        return listOfDevices;
    }

    public void setListOfDevices(InventoryCatalog listOfDevices) {
        this.listOfDevices = listOfDevices;
    }

    public String getWarehouseName() {
        return warehouseName;
    }

    public void setWarehouseName(String warehouseName) {
        this.warehouseName = warehouseName;
    }

    @Override
    public String toString() {
        return warehouseName;
    }
}
