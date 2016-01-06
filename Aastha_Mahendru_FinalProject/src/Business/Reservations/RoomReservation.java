/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Reservations;

import Business.Employee.Employee;
import Business.InventoryRecords.SurgeryRoom;
import Business.Organization.HospitalOrganization;
import java.util.Date;

/**
 *
 * @author Aastha
 */
public class RoomReservation {

    int reservationID;
    static int count = 0;
    SurgeryRoom room;
    Date reservationDate;
    Date reservedFrom;
    Date reservedTo;
    Employee reservedBy;
    HospitalOrganization horg;

    public Date getReservationDate() {
        return reservationDate;
    }

    public void setReservationDate(Date reservationDate) {
        this.reservationDate = reservationDate;
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

    public HospitalOrganization getHorg() {
        return horg;
    }

    public void setHorg(HospitalOrganization horg) {
        this.horg = horg;
    }

    public int getReservationID() {
        return reservationID;
    }

    public void setReservationID(int reservationID) {
        this.reservationID = reservationID;
    }

    public static int getCount() {
        return count;
    }

    public static void setCount(int count) {
        RoomReservation.count = count;
    }

    public SurgeryRoom getRoom() {
        return room;
    }

    public void setRoom(SurgeryRoom room) {
        this.room = room;
    }

    public Employee getReservedBy() {
        return reservedBy;
    }

    public void setReservedBy(Employee reservedBy) {
        this.reservedBy = reservedBy;
    }
}
