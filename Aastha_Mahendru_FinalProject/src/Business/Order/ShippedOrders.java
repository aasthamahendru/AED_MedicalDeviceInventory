/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Order;

import Business.Inventory.IDevice;
import Business.Organization.SupplierOrganization;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author Aastha
 */
public class ShippedOrders {

    Order order;
    Calendar orderDate;
    ArrayList<IDevice> tempList;
    SupplierOrganization supplierOrg;

    public ShippedOrders(Order order, Calendar orderDate, SupplierOrganization supplierOrg) {
        this.order = order;
        this.orderDate = orderDate;
        this.supplierOrg = supplierOrg;
        tempList = order.getWarehouse().getListOfDevices().getDeviceList();
        createAndAddInventoryDevice();
    }

    public void createAndAddInventoryDevice() {
        for (OrderItem oi : order.getListOfItemsOrdered()) {
            for (int i = 0; i < oi.getQuantity(); i++) {
                IDevice device = new IDevice();
                System.out.println(device.getInventoryIDNo());
                device.setWarehouse(order.getWarehouse());
                Date pdate = Calendar.getInstance().getTime();
                device.setPurchaseDate(pdate);

                Calendar exp = Calendar.getInstance();
                exp.add(Calendar.YEAR, 1);
                System.out.println(exp);
                System.out.println(orderDate);
                Date expDate = exp.getTime();
                device.setWarrantyExpiration(expDate);
                System.out.println(device.getWarrantyExpiration());
                device.getDeviceDetails().setS(supplierOrg.getS());

                Calendar maintenanceDate = Calendar.getInstance();
                maintenanceDate.add(Calendar.DATE, oi.getProduct().getMaintenanceDueAfter());
                Date maintenanceDue = maintenanceDate.getTime();
                device.getMaintenanceDetails().setMaintenanceDueDate(maintenanceDue);
                device.getDeviceDetails().setDeviceDescription(oi.getProduct().getDeviceDescription());
                device.getDeviceDetails().setModelNumber(oi.getProduct().getModelNumber());
                device.getDeviceDetails().setTypeOfDevice(oi.getProduct().getTypeOfDevice());
                device.getMaintenanceDetails().setMaintenanceProcedureDescription(oi.getProduct().getMaintenanceProcedureDescription());
                device.getMaintenanceDetails().setMaintenanceDueAfterEvery(oi.getProduct().getMaintenanceDueAfter());
                device.getMaintenanceDetails().setDevice(device);

                tempList.add(device);
            }
        }
        order.getWarehouse().getListOfDevices().setDeviceList(tempList);
    }

}
