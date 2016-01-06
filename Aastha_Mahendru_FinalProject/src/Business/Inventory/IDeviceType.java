/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Inventory;

import Business.Employee.Supplier;
import java.util.Comparator;

/**
 *
 * @author Aastha
 */
public class IDeviceType implements Comparable<IDeviceType> {

    String typeOfDevice;
    int modelNumber;
    String deviceDescription;
    int numberOfTimesReserved = 0;
    Supplier s;

    public Supplier getS() {
        return s;
    }

    public void setS(Supplier s) {
        this.s = s;
    }

    public int getNumberOfTimesReserved() {
        return numberOfTimesReserved;
    }

    public void setNumberOfTimesReserved(int numberOfTimesReserved) {
        this.numberOfTimesReserved = numberOfTimesReserved;
    }

    public String getTypeOfDevice() {
        return typeOfDevice;
    }

    public void setTypeOfDevice(String typeOfDevice) {
        this.typeOfDevice = typeOfDevice;
    }

    public int getModelNumber() {
        return modelNumber;
    }

    public void setModelNumber(int modelNumber) {
        this.modelNumber = modelNumber;
    }

    public String getDeviceDescription() {
        return deviceDescription;
    }

    public void setDeviceDescription(String deviceDescription) {
        this.deviceDescription = deviceDescription;
    }

    public int compareTo(IDeviceType comparetype) {
        String comparetypeofdevice = ((IDeviceType) comparetype).getTypeOfDevice();
        /* For Ascending order*/
        return this.typeOfDevice.compareTo(comparetypeofdevice);
    }

    @Override
    public String toString() {
        return typeOfDevice;
    }

    public static Comparator<IDeviceType> numberReservedComparator
            = new Comparator<IDeviceType>() {
                public int compare(IDeviceType idt1, IDeviceType idt2) {
                    int n1 = idt1.getNumberOfTimesReserved();
                    int n2 = idt2.getNumberOfTimesReserved();

                    return n2 - n1;
                }
            };
}
