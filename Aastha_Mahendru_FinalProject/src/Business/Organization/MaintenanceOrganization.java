/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Inventory.MaintenanceSchedule;
import Business.Role.MaintenanceEmployeeRole;
import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author Aastha
 */
public class MaintenanceOrganization extends Organization {

    MaintenanceSchedule maintenanceSchedule;

    public MaintenanceSchedule getMaintenanceSchedule() {
        return maintenanceSchedule;
    }

    public void setMaintenanceSchedule(MaintenanceSchedule maintenanceSchedule) {
        this.maintenanceSchedule = maintenanceSchedule;
    }

    public MaintenanceOrganization() {
        super(Organization.Type.Maintenance.getValue());
        maintenanceSchedule = new MaintenanceSchedule();
    }

    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList<>();
        roles.add(new MaintenanceEmployeeRole());
        return roles;
    }
}
