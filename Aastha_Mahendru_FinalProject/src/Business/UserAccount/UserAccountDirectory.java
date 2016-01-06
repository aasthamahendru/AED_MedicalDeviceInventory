/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.UserAccount;

import Business.Employee.Employee;
import Business.Network.Network;
import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author Aastha
 */
public class UserAccountDirectory {

    private ArrayList<UserAccount> userAccountList;

    public UserAccountDirectory() {
        userAccountList = new ArrayList<>();
    }

    public ArrayList<UserAccount> getUserAccountList() {
        return userAccountList;
    }

    public void removeUserAccount(UserAccount account) {
        userAccountList.remove(account);
    }

    public void changeStatus(UserAccount ua) {
        for (UserAccount ua1 : userAccountList) {
            if (ua1.equals(ua)) {
                if (ua1.getStatus().equals("Active")) {
                    ua1.setStatus("Disabled");
                } else {
                    ua1.setStatus("Active");
                }
            }
        }
    }

    public UserAccount authenticateUser(String username, String password) {
        for (UserAccount ua : userAccountList) {
            if (ua.getUsername().equals(username) && ua.getPassword().equals(password) && ua.getStatus().equals("Active")) {
                return ua;
            }
        }
        return null;
    }

    public UserAccount createUserAccount(String username, String password, Employee employee, Role role, Network network, String status) {
        UserAccount userAccount = new UserAccount();
        userAccount.setUsername(username);
        userAccount.setPassword(password);
        userAccount.setEmployee(employee);
        userAccount.setRole(role);
        userAccount.setStatus(status);
        userAccount.setNetwork(network);
        userAccountList.add(userAccount);
        return userAccount;

    }

    public boolean checkIfUsernameIsUnique(String username) {
        boolean check = true;
        for (UserAccount ua : userAccountList) {
            if (ua.getUsername().equals(username)) {
                check = false;
                break;
            }

        }
        return check;
    }
}
