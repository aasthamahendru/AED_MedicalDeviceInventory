/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.UserAccount;

import Business.Employee.Employee;
import Business.Network.Network;
import Business.RequestQueue.RequestQueue;
import Business.Role.Role;

/**
 *
 * @author Aastha
 */
public class UserAccount {

    private Network network;
    private String username;
    private String password;
    private Employee employee;
    private Role role;
    private String status = "Active";

    public Network getNetwork() {
        return network;
    }

    public void setNetwork(Network network) {
        this.network = network;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    private RequestQueue requestQueue;

    public UserAccount() {
        requestQueue = new RequestQueue();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Employee getEmployee() {
        return employee;
    }

    public RequestQueue getRequestQueue() {
        return requestQueue;
    }

    @Override
    public String toString() {
        return username;
    }

}
