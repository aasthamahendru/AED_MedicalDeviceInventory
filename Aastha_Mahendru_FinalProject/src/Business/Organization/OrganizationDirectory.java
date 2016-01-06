/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import java.util.ArrayList;

/**
 *
 * @author Aastha
 */
public class OrganizationDirectory {

    private ArrayList<Organization> organizationList;

    public OrganizationDirectory() {
        organizationList = new ArrayList<>();
    }

    public ArrayList<Organization> getOrganizationList() {
        return organizationList;
    }

    public Organization createOrganization(Organization.Type type) {
        Organization organization = null;
        if (type.getValue().equals(Organization.Type.Admin.getValue())) {
            organization = new AdminOrganization();
            organizationList.add(organization);
        } else if (type.getValue().equals(Organization.Type.Inventory.getValue())) {
            organization = new InventoryOrganization();
            organizationList.add(organization);
        } else if (type.getValue().equals(Organization.Type.Maintenance.getValue())) {
            organization = new MaintenanceOrganization();
            organizationList.add(organization);
        } else if (type.getValue().equals(Organization.Type.Hospital.getValue())) {
            organization = new HospitalOrganization();
            organizationList.add(organization);
        } else if (type.getValue().equals(Organization.Type.Supplier.getValue())) {
            organization = new SupplierOrganization();
            organizationList.add(organization);
        }
        return organization;
    }
}
