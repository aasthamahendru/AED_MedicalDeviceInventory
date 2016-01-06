/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import Business.Employee.Employee;

import Business.Role.SystemAdminRole;
import Business.UserAccount.UserAccount;

/**
 *
 * @author Aastha
 */
public class ConfigureSystem {

    public static EcoSystem configure() {

        EcoSystem system = EcoSystem.getInstance();

        Employee employee = system.getEmployeeDirectory().createEmployee("Aastha", "Mahendru", "754 Huntington Avenue, Boston, MA-02115", 1234567890);

        UserAccount ua = system.getUserAccountDirectory().createUserAccount("sysadmin", "sysadmin", employee, new SystemAdminRole(), null, "Active");

        return system;
    }
}
