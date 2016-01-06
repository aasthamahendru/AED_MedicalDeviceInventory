/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.InventoryRecords;

import java.util.ArrayList;

/**
 *
 * @author Aastha
 */
public class SurgeryRoomDirectory {

    ArrayList<SurgeryRoom> roomList;

    public ArrayList<SurgeryRoom> getRoomList() {
        return roomList;
    }

    public void setRoomList(ArrayList<SurgeryRoom> roomList) {
        this.roomList = roomList;
    }

    public SurgeryRoomDirectory() {
        roomList = new ArrayList<>();
    }

}
