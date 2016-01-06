/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Reservations;

import Business.Employee.Employee;
import Business.Inventory.IDevice;
import Business.InventoryRecords.SurgeryProcedure;
import Business.Organization.HospitalOrganization;
import java.util.Date;

/**
 *
 * @author Aastha
 */
public class DeviceReservation {

    int reservationID;
    static int count = 0;
    IDevice device;
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

    public int getReservationID() {
        return reservationID;
    }

    public void setReservationID(int reservationID) {
        this.reservationID = reservationID;
    }

    public HospitalOrganization getHorg() {
        return horg;
    }

    public void setHorg(HospitalOrganization horg) {
        this.horg = horg;
    }

    public SurgeryProcedure getSp() {
        return sp;
    }

    public void setSp(SurgeryProcedure sp) {
        this.sp = sp;
    }
    SurgeryProcedure sp;

    public DeviceReservation() {
        reservationID = count;
        count++;
    }

    public IDevice getDevice() {
        return device;
    }

    public void setDevice(IDevice device) {
        this.device = device;
    }

    public Employee getReservedBy() {
        return reservedBy;
    }

    public void setReservedBy(Employee reservedBy) {
        this.reservedBy = reservedBy;
    }
}
