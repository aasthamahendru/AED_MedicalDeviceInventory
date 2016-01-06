/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Employee;

import java.util.ArrayList;

/**
 *
 * @author Aastha
 */
public class EmployeeDirectory {

    private ArrayList<Employee> employeeList;

    public EmployeeDirectory() {
        employeeList = new ArrayList<>();
    }

    public ArrayList<Employee> getEmployeeList() {
        return employeeList;
    }

    public Employee createEmployee(String fname, String lname, String address, long contact) {
        Employee employee = new Employee();
        employee.setFirstName(fname);
        employee.setLastName(lname);
        employee.setAddress(address);
        employee.setContactNo(contact);
        employeeList.add(employee);
        return employee;
    }

    public void removeEmployee(Employee emp) {
        employeeList.remove(emp);
    }
}
