/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Role.CareTeamLeaderRole;
import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author Aastha
 */
public class HospitalOrganization extends Organization {

    String hospitalName;
    String address;
    long contactno;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public long getContactno() {
        return contactno;
    }

    public void setContactno(long contactno) {
        this.contactno = contactno;
    }

    public String getHospitalName() {
        return hospitalName;
    }

    public void setHospitalName(String hospitalName) {
        this.hospitalName = hospitalName;
    }

    public HospitalOrganization() {
        super(Organization.Type.Hospital.getValue());
    }

    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList<>();
        roles.add(new CareTeamLeaderRole());
        return roles;
    }

    public String toString() {
        return hospitalName;
    }
}
