/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Employee;

import Business.Supplier.SupplierCatalog;

/**
 *
 * @author Aastha
 */
public class Supplier extends Employee {

    String companyName;
    String ApprovalStatus = "Not Approved";
    private SupplierCatalog productCatalog;

    public static int getCount() {
        return count;
    }

    public static void setCount(int count) {
        Employee.count = count;
    }

    public Supplier() {
        productCatalog = new SupplierCatalog();
    }

    public String getApprovalStatus() {
        return ApprovalStatus;
    }

    public void setApprovalStatus(String ApprovalStatus) {
        this.ApprovalStatus = ApprovalStatus;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public SupplierCatalog getProductCatalog() {
        return productCatalog;
    }

    public void setProductCatalog(SupplierCatalog productCatalog) {
        this.productCatalog = productCatalog;
    }

    @Override
    public String toString() {
        return companyName;
    }
}
