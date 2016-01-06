/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Supplier;

import java.util.ArrayList;

/**
 *
 * @author Aastha
 */
public class SupplierCatalog {

    private ArrayList<SDeviceType> supplierCatalog;

    public ArrayList<SDeviceType> getSupplierCatalog() {
        return supplierCatalog;
    }

    public void setSupplierCatalog(ArrayList<SDeviceType> supplierCatalog) {
        this.supplierCatalog = supplierCatalog;
    }

    public SupplierCatalog() {
        supplierCatalog = new ArrayList<>();
    }

    public SDeviceType addProduct() {
        SDeviceType p = new SDeviceType();
        supplierCatalog.add(p);
        return p;
    }

    public void removeProduct(SDeviceType p) {
        supplierCatalog.remove(p);
    }

    public SDeviceType searchProductByName(String name) {
        for (SDeviceType p : supplierCatalog) {
            if (p.getTypeOfDevice().equals(name)) {
                return p;
            }
        }
        return null;
    }
}
