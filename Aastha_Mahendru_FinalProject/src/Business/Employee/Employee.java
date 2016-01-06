/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Employee;

/**
 *
 * @author Aastha
 */
public class Employee {

    private String firstName;
    private String lastName;
    private long contactNo;
    private String address;
    private int id;

    public long getContactNo() {
        return contactNo;
    }

    public void setContactNo(long ContactNo) {
        this.contactNo = ContactNo;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    static int count = 1;

    public Employee() {
        id = count;
        count++;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getId() {
        return id;
    }

}
