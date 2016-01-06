/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Inventory;

import Business.Employee.MaintenanceEmployee;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Aastha
 */
public class DeviceMaintenance {

    IDevice device;
    MaintenanceEmployee memp;
    String MaintenanceStatus = "Maintenance Up to Date";
    Date maintenanceDueDate;
    int maintenanceDueAfterEvery;           //no. of days after which maintenance of the device must be done
    String maintenanceProcedureDescription;
    ArrayList<MaintenanceHistory> maintenanceHistory;

    public DeviceMaintenance() {
        maintenanceHistory = new ArrayList<>();
    }

    public ArrayList<MaintenanceHistory> getMaintenanceHistory() {
        return maintenanceHistory;
    }

    public void setMaintenanceHistory(ArrayList<MaintenanceHistory> maintenanceHistory) {
        this.maintenanceHistory = maintenanceHistory;
    }

    public MaintenanceEmployee getMemp() {
        return memp;
    }

    public void setMemp(MaintenanceEmployee memp) {
        this.memp = memp;
    }

    public IDevice getDevice() {
        return device;
    }

    public void setDevice(IDevice device) {
        this.device = device;
    }

    public int getMaintenanceDueAfterEvery() {
        return maintenanceDueAfterEvery;
    }

    public void setMaintenanceDueAfterEvery(int maintenanceDueAfterEvery) {
        this.maintenanceDueAfterEvery = maintenanceDueAfterEvery;
    }

    public String getMaintenanceProcedureDescription() {
        return maintenanceProcedureDescription;
    }

    public void setMaintenanceProcedureDescription(String maintenanceProcedureDescription) {
        this.maintenanceProcedureDescription = maintenanceProcedureDescription;
    }

    public Date getMaintenanceDueDate() {
        return maintenanceDueDate;
    }

    public void setMaintenanceDueDate(Date maintenanceDueDate) {
        this.maintenanceDueDate = maintenanceDueDate;
    }

    public String getMaintenanceStatus() {
        return MaintenanceStatus;
    }

    public void setMaintenanceStatus(String MaintenanceStatus) {
        this.MaintenanceStatus = MaintenanceStatus;
    }

    @Override
    public String toString() {
        return MaintenanceStatus;
    }
}
