/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Inventory;

import Business.Employee.MaintenanceEmployee;
import java.util.Date;

/**
 *
 * @author Aastha
 */
public class MaintenanceHistory {

    Date lastMaintenanceDate;
    MaintenanceEmployee memp;
    String maintenanceNotes;

    public MaintenanceHistory() {
        memp = new MaintenanceEmployee();
    }

    public Date getLastMaintenanceDate() {
        return lastMaintenanceDate;
    }

    public void setLastMaintenanceDate(Date lastMaintenanceDate) {
        this.lastMaintenanceDate = lastMaintenanceDate;
    }

    public MaintenanceEmployee getMemp() {
        return memp;
    }

    public void setMemp(MaintenanceEmployee memp) {
        this.memp = memp;
    }

    public String getMaintenanceNotes() {
        return maintenanceNotes;
    }

    public void setMaintenanceNotes(String maintenanceNotes) {
        this.maintenanceNotes = maintenanceNotes;
    }
}
