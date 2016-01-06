/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Role;

import Business.EcoSystem;
import Business.Employee.Supplier;
import Business.Enterprise.Enterprise;
import Business.Network.Network;
import Business.Organization.Organization;
import Business.Organization.SupplierOrganization;
import Business.UserAccount.UserAccount;
import UserInterface.Supplier.SupplierWorkAreaJPanel;
import javax.swing.JPanel;

/**
 *
 * @author Aastha
 */
public class SupplierRole extends Role {

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, Network network, EcoSystem business) {
        return new SupplierWorkAreaJPanel(userProcessContainer, (Supplier) account.getEmployee(), account, (SupplierOrganization) organization, network, business);

    }
}
