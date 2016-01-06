/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.CareTeamLeaderWorkArea;

import Business.Employee.CareTeamLeader;
import Business.Enterprise.Enterprise;
import Business.Enterprise.EnterpriseDirectory;
import Business.Enterprise.InventoryEnterprise;
import Business.Inventory.IDevice;
import Business.Inventory.IDeviceType;
import Business.Inventory.Warehouse;
import Business.InventoryRecords.SurgeryProcedure;
import Business.InventoryRecords.SurgeryProcedureDirectory;
import Business.InventoryRecords.SurgeryRoom;
import Business.Network.Network;
import Business.Organization.HospitalOrganization;
import Business.Organization.InventoryOrganization;
import Business.Organization.Organization;
import Business.Reservations.DeviceReservation;
import Business.Reservations.RoomReservation;
import Business.Reservations.SurgeryReservation;
import Business.UserAccount.UserAccount;
import java.awt.CardLayout;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Aastha
 */
public class MakeReservationsJPanel extends javax.swing.JPanel {

    JPanel upc;
    UserAccount ua;
    CareTeamLeader emp;
    Network network;
    InventoryEnterprise iEnt;
    InventoryOrganization iOrg;
    SurgeryProcedureDirectory spDirectory;
    ArrayList<JCheckBox> devicesAvailableCheckBoxes;
    ArrayList<IDevice> devicesAvailable;
    ArrayList<JCheckBox> roomsAvailableCheckBoxes;
    ArrayList<SurgeryRoom> roomsAvailable;
    ArrayList<IDevice> reservedDevices;
    SurgeryRoom reservedRoom;
    SurgeryProcedure surgery;
    Calendar cfrom;
    Calendar cto;
    HospitalOrganization horg;

    /**
     * Creates new form MakeJPanel
     */
    public MakeReservationsJPanel(JPanel upc, UserAccount ua, CareTeamLeader emp, HospitalOrganization horg, Network network) {
        initComponents();
        this.upc = upc;
        this.ua = ua;
        this.emp = emp;
        this.horg = horg;
        this.network = network;
        devicesAvailable = new ArrayList<>();
        roomsAvailable = new ArrayList<>();
        reservedDevices = new ArrayList<>();
        reservedRoom = new SurgeryRoom();
        devicesAvailableCheckBoxes = new ArrayList<>();
        roomsAvailableCheckBoxes = new ArrayList<>();
        jDateChooser2.setMinSelectableDate(new Date());
        GridLayout gdlt = new GridLayout(5, 7);
        devicesJPanel.setLayout(gdlt);
        roomsJPanel.setLayout(gdlt);

        EnterpriseDirectory ed = network.getEnterpriseDirectory();
        for (Enterprise e : ed.getEnterpriseList()) {
            if (e instanceof InventoryEnterprise) {
                iEnt = (InventoryEnterprise) e;
                break;
            }
        }
        for (Organization org : iEnt.getOrganizationDirectory().getOrganizationList()) {
            if (org instanceof InventoryOrganization) {
                iOrg = (InventoryOrganization) org;
            }
        }
        spDirectory = iOrg.getSurgeryProcedureDirectory();
        populateSpinners();
        populateComboBox();
    }

    public void populateSpinners() {
        for (int i = 00; i <= 23; i++) {
            fHourComboBox.addItem(i);

        }
        for (int j = 0; j < 60; j = j + 30) {
            fMinComboBox.addItem(j);
        }

        for (int i = 00; i <= 24; i++) {
            tHourComboBox.addItem(i);

        }
        for (int j = 00; j < 60; j = j + 30) {
            tMinComboBox.addItem(j);
        }

    }

    public void populateComboBox() {
        surgeriesJComboBox.removeAllItems();
        for (SurgeryProcedure sp : spDirectory.getListOfSurgeries()) {
            surgeriesJComboBox.addItem(sp);
        }
    }

    public void generateAvailableDevicesCheckBoxes(Calendar cfrom, Calendar cto) {
        boolean isReserved = false;
        SurgeryProcedure sp = (SurgeryProcedure) surgeriesJComboBox.getSelectedItem();
        for (Warehouse w : iOrg.getWarehouseDirectory().getWarehouseList()) {
            for (IDevice device : w.getListOfDevices().getDeviceList()) {
                for (SurgeryProcedure s : iOrg.getSurgeryProcedureDirectory().getListOfSurgeries()) {
                    if (s.getName().equals(sp.getName())) {
                        for (IDeviceType idt : s.getDevicesUsed()) {
                            if (device.getDeviceDetails().getTypeOfDevice().equals(idt.getTypeOfDevice())) {
                                if (!device.getMaintenanceDetails().getMaintenanceStatus().equals("Maintenance in progress") && !device.getMaintenanceDetails().getMaintenanceStatus().equals("Maintenance Due")) {
                                    if (!device.getReservations().isEmpty()) {
                                        for (DeviceReservation dr : device.getReservations()) {
                                            Calendar rfrom = Calendar.getInstance();
                                            rfrom.setTime(dr.getReservedFrom());
                                            Calendar rto = Calendar.getInstance();
                                            rto.setTime(dr.getReservedTo());
                                            if ((rfrom.before(cfrom) && cfrom.before(rto)) || (rfrom.before(cto)) && cto.before(rto)) {
                                                isReserved = true;
                                                break;
                                            }
                                        }
                                        if (isReserved == false) {
                                            devicesAvailable.add(device);
                                            JCheckBox box = new JCheckBox(device.getInventoryIDNo() + ", " + device.getDeviceDetails().getTypeOfDevice());
                                            devicesJPanel.add(box);
                                            devicesAvailableCheckBoxes.add(box);
                                            box.setVisible(true);
                                            devicesJPanel.revalidate();
                                            devicesJPanel.repaint();
                                        }
                                    } else {
                                        devicesAvailable.add(device);
                                        JCheckBox box = new JCheckBox(device.getInventoryIDNo() + ", " + device.getDeviceDetails().getTypeOfDevice());
                                        devicesJPanel.add(box);
                                        devicesAvailableCheckBoxes.add(box);
                                        box.setVisible(true);
                                        devicesJPanel.revalidate();
                                        devicesJPanel.repaint();
                                    }
                                }

                            }
                        }
                    }
                }
            }
        }
    }

    public void generateAvailableRoomsCheckBoxes(Calendar cfrom, Calendar cto) {
        boolean isReserved = false;
        SurgeryProcedure sp = (SurgeryProcedure) surgeriesJComboBox.getSelectedItem();
        for (SurgeryProcedure s : iOrg.getSurgeryProcedureDirectory().getListOfSurgeries()) {
            if (s.getName().equals(sp.getName())) {
                for (SurgeryRoom srRequired : s.getRoomListForThisSurgery()) {
                    for (SurgeryRoom sr : iOrg.getSurgeryRoomDirectory().getRoomList()) {
                        if (srRequired.getHospital().equals(sr.getHospital()) && String.valueOf(srRequired.getRoomNo()).equals(String.valueOf(sr.getRoomNo()))) {
                            if (!srRequired.getReservations().isEmpty()) {
                                for (RoomReservation rr : srRequired.getReservations()) {
                                    Calendar rfrom = Calendar.getInstance();
                                    rfrom.setTime(rr.getReservedFrom());
                                    Calendar rto = Calendar.getInstance();
                                    rto.setTime(rr.getReservedTo());
                                    if ((rfrom.before(cfrom) && cfrom.before(rto)) || (rfrom.before(cto)) && cto.before(rto)) {
                                        isReserved = true;
                                        break;
                                    }
                                }
                                if (isReserved == false) {
                                    roomsAvailable.add(srRequired);
                                    JCheckBox box = new JCheckBox(srRequired.getRoomNo() + ", " + srRequired.getHospital());
                                    roomsJPanel.add(box);
                                    roomsAvailableCheckBoxes.add(box);
                                    box.setVisible(true);
                                    roomsJPanel.revalidate();
                                    roomsJPanel.repaint();
                                }
                            } else {
                                roomsAvailable.add(srRequired);
                                JCheckBox box = new JCheckBox(srRequired.getRoomNo() + ", " + srRequired.getHospital());
                                roomsJPanel.add(box);
                                roomsAvailableCheckBoxes.add(box);
                                box.setVisible(true);
                                roomsJPanel.revalidate();
                                roomsJPanel.repaint();
                            }

                        }
                    }
                }
            }
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        surgeriesJComboBox = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        searchJButton = new javax.swing.JButton();
        roomsJPanel = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        devicesJPanel = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        reserveJButton = new javax.swing.JButton();
        fHourComboBox = new javax.swing.JComboBox();
        fMinComboBox = new javax.swing.JComboBox();
        tHourComboBox = new javax.swing.JComboBox();
        tMinComboBox = new javax.swing.JComboBox();
        jDateChooser2 = new com.toedter.calendar.JDateChooser();
        jLabel8 = new javax.swing.JLabel();
        backjButton2 = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Select Surgery Procedure:");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(32, 61, -1, -1));

        surgeriesJComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                surgeriesJComboBoxActionPerformed(evt);
            }
        });
        add(surgeriesJComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 60, 310, -1));

        jLabel2.setText("From:");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 110, -1, -1));

        jLabel3.setText("To:");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 110, -1, -1));

        searchJButton.setText("Search Availability>>");
        searchJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchJButtonActionPerformed(evt);
            }
        });
        add(searchJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 110, -1, -1));

        roomsJPanel.setBackground(new java.awt.Color(255, 255, 255));
        roomsJPanel.setLayout(new java.awt.GridBagLayout());
        add(roomsJPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 330, 830, 120));

        jLabel4.setText("Select Devices to Reserve:");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 190, -1, -1));

        jLabel5.setText("Select Room to Reserve:");
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 330, -1, -1));

        devicesJPanel.setBackground(new java.awt.Color(255, 255, 255));
        devicesJPanel.setLayout(new java.awt.GridBagLayout());
        add(devicesJPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 190, 830, 120));
        add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(356, 11, -1, -1));

        jLabel7.setText("Select Date:");
        add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(32, 109, -1, -1));

        reserveJButton.setText("Reserve");
        reserveJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reserveJButtonActionPerformed(evt);
            }
        });
        add(reserveJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 470, -1, -1));

        add(fHourComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 110, 50, -1));

        add(fMinComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 110, 50, -1));

        add(tHourComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 110, 50, -1));

        add(tMinComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 110, 50, -1));
        add(jDateChooser2, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 110, 160, -1));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel8.setText("Make Reservations");
        add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 20, -1, -1));

        backjButton2.setText("<<Back");
        backjButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backjButton2ActionPerformed(evt);
            }
        });
        add(backjButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 490, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void searchJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchJButtonActionPerformed
        int h = (int) fHourComboBox.getSelectedItem();
        int m = (int) fMinComboBox.getSelectedItem();
        int hto = (int) tHourComboBox.getSelectedItem();
        int mto = (int) tMinComboBox.getSelectedItem();

        cfrom = new GregorianCalendar();
        cfrom.set(jDateChooser2.getCalendar().get(Calendar.YEAR), jDateChooser2.getCalendar().get(Calendar.MONTH), jDateChooser2.getCalendar().get(Calendar.DAY_OF_MONTH), h, m);

        cto = new GregorianCalendar();
        cto.set(jDateChooser2.getCalendar().get(Calendar.YEAR), jDateChooser2.getCalendar().get(Calendar.MONTH), jDateChooser2.getCalendar().get(Calendar.DAY_OF_MONTH), hto, mto);

        Calendar c = Calendar.getInstance();
        c.add(Calendar.DAY_OF_MONTH, 2);        //There must be a difference of atleast 2 days between current date and date of booking.
        if (c.before(cfrom)) {

            if (cfrom.compareTo(cto) > 0) {
                JOptionPane.showMessageDialog(null, "Please enter correct timings.");
                return;
            }
            generateAvailableDevicesCheckBoxes(cfrom, cto);
            generateAvailableRoomsCheckBoxes(cfrom, cto);
        } else {

            JOptionPane.showMessageDialog(null, "Bookings have to be done atleast 3 days prior to the date of reservation.");
            return;
        }
    }//GEN-LAST:event_searchJButtonActionPerformed

    private void reserveJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reserveJButtonActionPerformed
        String[] splitItem = new String[2];
        String[] splitType = new String[2];
        for (JCheckBox cbox : devicesAvailableCheckBoxes) {
            if (cbox.isSelected()) {
                String type = cbox.getText();
                splitType = type.split(", ");
                for (IDevice d : devicesAvailable) {
                    if (splitType[0].equals(String.valueOf(d.getInventoryIDNo())) && splitType[1].equals(d.getDeviceDetails().getTypeOfDevice())) {
                        reservedDevices.add(d);
                    }
                }
            }
        }

        SurgeryReservation reservation = new SurgeryReservation();

        for (JCheckBox cbox : roomsAvailableCheckBoxes) {
            if (cbox.isSelected()) {
                String item = cbox.getText();
                splitItem = item.split(", ");
                for (SurgeryRoom sr : roomsAvailable) {
                    if (splitItem[0].equals(String.valueOf(sr.getRoomNo())) && splitItem[1].equals(sr.getHospital().getHospitalName())) {

                        RoomReservation rr = new RoomReservation();
                        rr.setReservationDate(cfrom.getTime());
                        rr.setReservedBy(emp);
                        rr.setReservedFrom(cfrom.getTime());
                        rr.setReservedTo(cto.getTime());
                        rr.setRoom(sr);
                        rr.setHorg(horg);
                        sr.getReservations().add(rr);
                        reservation.setRoomReserved(rr);
                        iOrg.getSurgeriesSchedule().getSchedule().add(reservation);

                    }
                }
            }
        }

        for (IDevice dev : reservedDevices) {
            DeviceReservation dr = new DeviceReservation();
            dr.setDevice(dev);
            dr.setReservedBy(emp);
            dr.setReservationDate(cfrom.getTime());
            dr.setReservedFrom(cfrom.getTime());
            dr.setReservedTo(cto.getTime());
            dr.setHorg(horg);
            dev.getReservations().add(dr);
            reservation.getDevicesReserved().add(dr);
        }

        surgery = (SurgeryProcedure) surgeriesJComboBox.getSelectedItem();

        reservation.setReservedFrom(cfrom.getTime());
        reservation.setReservedTo(cto.getTime());
        reservation.setSurgery(surgery);

        JOptionPane.showMessageDialog(null, "Reservation Complete.");


    }//GEN-LAST:event_reserveJButtonActionPerformed

    private void surgeriesJComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_surgeriesJComboBoxActionPerformed

    }//GEN-LAST:event_surgeriesJComboBoxActionPerformed

    private void backjButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backjButton2ActionPerformed

        upc.remove(this);
        CardLayout layout = (CardLayout) upc.getLayout();
        layout.previous(upc);
    }//GEN-LAST:event_backjButton2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backjButton2;
    private javax.swing.JPanel devicesJPanel;
    private javax.swing.JComboBox fHourComboBox;
    private javax.swing.JComboBox fMinComboBox;
    private com.toedter.calendar.JDateChooser jDateChooser2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JButton reserveJButton;
    private javax.swing.JPanel roomsJPanel;
    private javax.swing.JButton searchJButton;
    private javax.swing.JComboBox surgeriesJComboBox;
    private javax.swing.JComboBox tHourComboBox;
    private javax.swing.JComboBox tMinComboBox;
    // End of variables declaration//GEN-END:variables
}
