/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Network;

import Business.Enterprise.EnterpriseDirectory;
import Business.Order.MasterOrderCatalog;
import Business.Organization.Organization;
import Business.UserAccount.UserAccountDirectory;

/**
 *
 * @author Aastha
 */
public class Network {

    UserAccountDirectory networkUserAccountDirectory;
    private MasterOrderCatalog moc;
    private String name;
    private EnterpriseDirectory enterpriseDirectory;

    public Network() {
        enterpriseDirectory = new EnterpriseDirectory();
        moc = new MasterOrderCatalog();
        networkUserAccountDirectory = new UserAccountDirectory();
    }

    public UserAccountDirectory getNetworkUserAccountDirectory() {
        return networkUserAccountDirectory;
    }

    public void setNetworkUserAccountDirectory(UserAccountDirectory networkUserAccountDirectory) {
        this.networkUserAccountDirectory = networkUserAccountDirectory;
    }

    public MasterOrderCatalog getMoc() {
        return moc;
    }

    public void setMoc(MasterOrderCatalog moc) {
        this.moc = moc;
    }

    public EnterpriseDirectory getEnterpriseDirectory() {
        return enterpriseDirectory;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

}
