/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import Business.Enterprise.Enterprise;
import Business.Enterprise.EnterpriseDirectory;
import Business.Network.Network;
import Business.Order.MasterOrderCatalog;
import Business.Organization.Organization;
import Business.Role.AdminRole;
import Business.Role.Role;
import Business.UserAccount.UserAccount;
import java.util.ArrayList;

/**
 *
 * @author Aastha
 */
public class EcoSystem extends Organization {

    private static EcoSystem business;
    private ArrayList<Network> networkList;
   // private MasterOrderCatalog moc;

//    public MasterOrderCatalog getMoc() {
//        return moc;
//    }
    public static EcoSystem getInstance() {
        if (business == null) {
            business = new EcoSystem();

        }
        return business;
    }

    private EcoSystem() {
        super(null);
        networkList = new ArrayList<>();
        // moc = new MasterOrderCatalog();
    }

    public ArrayList<Network> getNetworkList() {
        return networkList;
    }

    public Network createAndAddNetwork() {
        Network network = new Network();
        networkList.add(network);
        return network;
    }

    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roleList = new ArrayList<>();
        roleList.add(new AdminRole());
        return roleList;
    }

    public boolean checkIfUsernameIsUnique(String username) {
        boolean check = true;
        for (Network n : getNetworkList()) {
            for (Enterprise e : n.getEnterpriseDirectory().getEnterpriseList()) {
                for (UserAccount ua : e.getUserAccountDirectory().getUserAccountList()) {
                    if (ua.getUsername().equals(username)) {
                        check = false;
                    }
                }
            }
        }
        return check;
    }

}
