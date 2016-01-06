/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Supplier;

import Business.Employee.Supplier;

/**
 *
 * @author Aastha
 */
public class SDeviceType {

    String typeOfDevice;
    int modelNumber;
    String maintenanceProcedureDescription;
    String deviceDescription;
    static int count = 0;
    int cost;
    Supplier supplier;
    int maintenanceDueAfter;

    public int getMaintenanceDueAfter() {
        return maintenanceDueAfter;
    }

    public void setMaintenanceDueAfter(int maintenanceDueAfter) {
        this.maintenanceDueAfter = maintenanceDueAfter;
    }

    public String getMaintenanceProcedureDescription() {
        return maintenanceProcedureDescription;
    }

    public void setMaintenanceProcedureDescription(String maintenanceProcedureDescription) {
        this.maintenanceProcedureDescription = maintenanceProcedureDescription;
    }

    public int getModelNumber() {
        return modelNumber;
    }

    public void setModelNumber(int modelNumber) {
        this.modelNumber = modelNumber;
    }

    public SDeviceType() {
        count++;
        modelNumber = count;
    }

    public String getTypeOfDevice() {
        return typeOfDevice;
    }

    public void setTypeOfDevice(String typeOfDevice) {
        this.typeOfDevice = typeOfDevice;
    }

    public String getDeviceDescription() {
        return deviceDescription;
    }

    public void setDeviceDescription(String deviceDescription) {
        this.deviceDescription = deviceDescription;
    }

    public static int getCount() {
        return count;
    }

    public static void setCount(int count) {
        SDeviceType.count = count;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

    @Override
    public String toString() {
        return typeOfDevice;
    }
}
