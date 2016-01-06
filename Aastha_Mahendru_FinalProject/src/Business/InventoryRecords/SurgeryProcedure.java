/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.InventoryRecords;

import Business.Inventory.IDeviceType;
import java.util.ArrayList;

/**
 *
 * @author Aastha
 */
public class SurgeryProcedure {

    String name;
    static int count = 0;
    int id;
    String description;
    ArrayList<IDeviceType> devicesUsed;
    ArrayList<SurgeryRoom> roomListForThisSurgery;

    public SurgeryProcedure() {
        devicesUsed = new ArrayList<>();
        roomListForThisSurgery = new ArrayList<>();
        count++;
        id = count;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ArrayList<IDeviceType> getDevicesUsed() {
        return devicesUsed;
    }

    public void setDevicesUsed(ArrayList<IDeviceType> devicesUsed) {
        this.devicesUsed = devicesUsed;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static int getCount() {
        return count;
    }

    public static void setCount(int count) {
        SurgeryProcedure.count = count;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ArrayList<SurgeryRoom> getRoomListForThisSurgery() {
        return roomListForThisSurgery;
    }

    public void setRoomListForThisSurgery(ArrayList<SurgeryRoom> roomListForThisSurgery) {
        this.roomListForThisSurgery = roomListForThisSurgery;
    }

    @Override
    public String toString() {
        return name;
    }
}
