/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.InventoryRecords;

import java.util.ArrayList;

/**
 *
 * @author Aastha
 */
public class SurgeryProcedureDirectory {

    ArrayList<SurgeryProcedure> listOfSurgeries;

    public ArrayList<SurgeryProcedure> getListOfSurgeries() {
        return listOfSurgeries;
    }

    public void setListOfSurgeries(ArrayList<SurgeryProcedure> listOfSurgeries) {
        this.listOfSurgeries = listOfSurgeries;
    }

    public SurgeryProcedureDirectory() {
        listOfSurgeries = new ArrayList<>();
    }
}
