/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Inventory;

import java.util.ArrayList;

/**
 *
 * @author Aastha
 */
public class WarehouseDirectory {

    ArrayList<Warehouse> warehouseList;

    public WarehouseDirectory() {
        warehouseList = new ArrayList<>();
    }

    public ArrayList<Warehouse> getWarehouseList() {
        return warehouseList;
    }

    public void setWarehouseList(ArrayList<Warehouse> warehouseList) {
        this.warehouseList = warehouseList;
    }

    public void addWarehouse(String name, String address) {
        Warehouse w = new Warehouse();
        w.setAddress(address);
        w.setWarehouseName(name);
        warehouseList.add(w);

    }

    public void removeWarehouse(Warehouse w) {
        warehouseList.remove(w);
    }

}
