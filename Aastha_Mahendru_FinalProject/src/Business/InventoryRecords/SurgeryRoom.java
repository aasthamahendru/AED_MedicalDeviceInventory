/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.InventoryRecords;

import Business.Organization.HospitalOrganization;
import Business.Reservations.RoomReservation;
import java.util.ArrayList;

/**
 *
 * @author Aastha
 */
public class SurgeryRoom {

    int roomNo;
    HospitalOrganization hospital;
    String roomDescription;
    ArrayList<RoomReservation> reservations;

    public SurgeryRoom() {
        hospital = new HospitalOrganization();
        reservations = new ArrayList<>();
    }

    public ArrayList<RoomReservation> getReservations() {
        return reservations;
    }

    public void setReservations(ArrayList<RoomReservation> reservations) {
        this.reservations = reservations;
    }

    public String getRoomDescription() {
        return roomDescription;
    }

    public void setRoomDescription(String roomDescription) {
        this.roomDescription = roomDescription;
    }

    public int getRoomNo() {
        return roomNo;
    }

    public void setRoomNo(int roomNo) {
        this.roomNo = roomNo;
    }

    public HospitalOrganization getHospital() {
        return hospital;
    }

    public void setHospital(HospitalOrganization hospital) {
        this.hospital = hospital;
    }

    @Override
    public String toString() {
        return String.valueOf(roomNo + ", " + hospital);
    }
}
