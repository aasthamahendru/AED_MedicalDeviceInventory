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
public class InventoryCatalog {

    ArrayList<IDevice> deviceList;

    static int count = 0;

    public static int getCount() {
        return count;
    }

    public static void setCount(int count) {
        InventoryCatalog.count = count;
    }

    public ArrayList<IDevice> getDeviceList() {
        return deviceList;
    }

    public void setDeviceList(ArrayList<IDevice> deviceList) {
        this.deviceList = deviceList;
    }

    public InventoryCatalog() {
        deviceList = new ArrayList<>();
    }

}
