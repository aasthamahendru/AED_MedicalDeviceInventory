/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Inventory;

import Business.Reservations.DeviceReservation;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 *
 * @author Aastha
 */
public class IDevice {

    static int count = 0;
    int inventoryIDNo;
    Warehouse warehouse;            //Warehouse the device is currently in.
    Date PurchaseDate;
    Date WarrantyExpiration;
    ArrayList<DeviceReservation> reservations;
    IDeviceType deviceDetails;
    DeviceMaintenance maintenanceDetails;

    public IDevice() {
        inventoryIDNo = count;
        count++;
        deviceDetails = new IDeviceType();
        warehouse = new Warehouse();
        maintenanceDetails = new DeviceMaintenance();
        reservations = new ArrayList<>();
    }

    public boolean isMaintenanceDue() {
        Calendar c = new GregorianCalendar();
        System.out.println(maintenanceDetails.getMaintenanceDueDate());
        c.setTime(maintenanceDetails.getMaintenanceDueDate());
        System.out.println(c.getTime());
        if (c.getTime().before(Calendar.getInstance().getTime())) {
            return true;
        } else {
            return false;
        }
    }

    public void updateMaintenanceDueDate() {

        maintenanceDetails.setMaintenanceStatus("Maintenance Up to Date");
        System.out.println(maintenanceDetails.getMaintenanceStatus());
        Calendar c = Calendar.getInstance();
        c.add(Calendar.DATE, maintenanceDetails.getMaintenanceDueAfterEvery());
        maintenanceDetails.setMaintenanceDueDate(c.getTime());

    }

    public ArrayList<DeviceReservation> getReservations() {
        return reservations;
    }

    public void setReservations(ArrayList<DeviceReservation> reservations) {
        this.reservations = reservations;
    }

    public DeviceMaintenance getMaintenanceDetails() {
        return maintenanceDetails;
    }

    public void setMaintenanceDetails(DeviceMaintenance maintenanceDetails) {
        this.maintenanceDetails = maintenanceDetails;
    }

    public Date getWarrantyExpiration() {
        return WarrantyExpiration;
    }

    public void setWarrantyExpiration(Date WarrantyExpiration) {
        this.WarrantyExpiration = WarrantyExpiration;
    }

    public IDeviceType getDeviceDetails() {
        return deviceDetails;
    }

    public void setDeviceDetails(IDeviceType deviceDetails) {
        this.deviceDetails = deviceDetails;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getInventoryIDNo() {
        return inventoryIDNo;
    }

    public Warehouse getWarehouse() {
        return warehouse;
    }

    public void setWarehouse(Warehouse warehouse) {
        this.warehouse = warehouse;
    }

    public Date getPurchaseDate() {
        return PurchaseDate;
    }

    public void setPurchaseDate(Date PurchaseDate) {
        this.PurchaseDate = PurchaseDate;
    }

    @Override
    public String toString() {
        return String.valueOf(inventoryIDNo);
    }

}
