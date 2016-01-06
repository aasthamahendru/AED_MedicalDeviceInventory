/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Employee;

import Business.Organization.HospitalOrganization;

/**
 *
 * @author Aastha
 */
public class CareTeamLeader extends Employee {

    HospitalOrganization hospital;              //the hospital the careLeader belongs to.

    public HospitalOrganization getHospital() {
        return hospital;
    }

    public void setHospital(HospitalOrganization hospital) {
        this.hospital = hospital;
    }

    @Override
    public String toString() {
        return super.getFirstName() + " " + super.getLastName();
    }
}
