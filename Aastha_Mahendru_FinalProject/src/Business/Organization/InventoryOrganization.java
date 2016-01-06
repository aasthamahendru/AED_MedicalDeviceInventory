/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Inventory.WarehouseDirectory;
import Business.InventoryRecords.SurgeryProcedureDirectory;
import Business.InventoryRecords.SurgeryRoomDirectory;
import Business.Reservations.SurgeriesSchedule;
import Business.Role.Role;
import Business.Role.WarehouseManagerRole;
import java.util.ArrayList;

/**
 *
 * @author Aastha
 */
public class InventoryOrganization extends Organization {

    private WarehouseDirectory warehouseDirectory;
    private SurgeryProcedureDirectory surgeryProcedureDirectory;
    private SurgeryRoomDirectory surgeryRoomDirectory;
    private SurgeriesSchedule surgeriesSchedule;

    public InventoryOrganization() {
        super(Organization.Type.Inventory.getValue());
        warehouseDirectory = new WarehouseDirectory();
        surgeryProcedureDirectory = new SurgeryProcedureDirectory();
        surgeryRoomDirectory = new SurgeryRoomDirectory();
        surgeriesSchedule = new SurgeriesSchedule();
    }

    public SurgeriesSchedule getSurgeriesSchedule() {
        return surgeriesSchedule;
    }

    public void setSurgeriesSchedule(SurgeriesSchedule surgeriesSchedule) {
        this.surgeriesSchedule = surgeriesSchedule;
    }

    public SurgeryProcedureDirectory getSurgeryProcedureDirectory() {
        return surgeryProcedureDirectory;
    }

    public void setSurgeryProcedureDirectory(SurgeryProcedureDirectory surgeryProcedureDirectory) {
        this.surgeryProcedureDirectory = surgeryProcedureDirectory;
    }

    public SurgeryRoomDirectory getSurgeryRoomDirectory() {
        return surgeryRoomDirectory;
    }

    public void setSurgeryRoomDirectory(SurgeryRoomDirectory surgeryRoomDirectory) {
        this.surgeryRoomDirectory = surgeryRoomDirectory;
    }

    public WarehouseDirectory getWarehouseDirectory() {
        return warehouseDirectory;
    }

    public void setWarehouseDirectory(WarehouseDirectory warehouseDirectory) {
        this.warehouseDirectory = warehouseDirectory;
    }

    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList<>();
        roles.add(new WarehouseManagerRole());

        return roles;
    }
}
