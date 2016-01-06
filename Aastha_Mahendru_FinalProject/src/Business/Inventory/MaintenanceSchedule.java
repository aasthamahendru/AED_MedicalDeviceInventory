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
public class MaintenanceSchedule {

    ArrayList<DeviceMaintenance> mSchedule;

    public ArrayList<DeviceMaintenance> getmSchedule() {
        return mSchedule;
    }

    public void setmSchedule(ArrayList<DeviceMaintenance> mSchedule) {
        this.mSchedule = mSchedule;
    }

    public MaintenanceSchedule() {
        mSchedule = new ArrayList<>();
    }
}
