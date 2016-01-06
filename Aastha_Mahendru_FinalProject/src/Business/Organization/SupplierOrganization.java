/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Employee.Supplier;
import Business.Role.Role;
import Business.Role.SupplierRole;
import java.util.ArrayList;

/**
 *
 * @author Aastha
 */
public class SupplierOrganization extends Organization {

    Supplier s;

    public Supplier getS() {
        return s;
    }

    public void setS(Supplier s) {
        this.s = s;
    }

    public SupplierOrganization() {
        super(Type.Supplier.getValue());
    }

    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList<>();
        roles.add(new SupplierRole());
        return roles;
    }

    public String toString() {
        return s.getCompanyName();
    }
}
