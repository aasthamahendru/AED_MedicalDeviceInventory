/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Reservations;

import Business.InventoryRecords.SurgeryProcedure;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Aastha
 */
public class SurgeryReservation {

    int reservationId;
    static int count = 0;
    SurgeryProcedure surgery;
    ArrayList<DeviceReservation> devicesReserved;
    RoomReservation roomReserved;
    Date reservedFrom;
    Date reservedTo;
    Date reservationDate;

    public int getReservationId() {
        return reservationId;
    }

    public void setReservationId(int reservationId) {
        this.reservationId = reservationId;
    }

    public Date getReservedFrom() {
        return reservedFrom;
    }

    public void setReservedFrom(Date reservedFrom) {
        this.reservedFrom = reservedFrom;
    }

    public Date getReservedTo() {
        return reservedTo;
    }

    public void setReservedTo(Date reservedTo) {
        this.reservedTo = reservedTo;
    }

    public Date getReservationDate() {
        return reservationDate;
    }

    public void setReservationDate(Date reservationDate) {
        this.reservationDate = reservationDate;
    }

    public SurgeryReservation() {
        reservationId = count;
        count++;
        devicesReserved = new ArrayList<>();
    }

    public ArrayList<DeviceReservation> getDevicesReserved() {
        return devicesReserved;
    }

    public void setDevicesReserved(ArrayList<DeviceReservation> devicesReserved) {
        this.devicesReserved = devicesReserved;
    }

    public RoomReservation getRoomReserved() {
        return roomReserved;
    }

    public void setRoomReserved(RoomReservation roomReserved) {
        this.roomReserved = roomReserved;
    }

    public SurgeryProcedure getSurgery() {
        return surgery;
    }

    public void setSurgery(SurgeryProcedure surgery) {
        this.surgery = surgery;
    }

}
