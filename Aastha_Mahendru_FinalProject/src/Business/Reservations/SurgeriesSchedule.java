/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Reservations;

import java.util.ArrayList;

/**
 *
 * @author Aastha
 */
public class SurgeriesSchedule {

    ArrayList<SurgeryReservation> schedule;

    public SurgeriesSchedule() {
        schedule = new ArrayList<>();
    }

    public ArrayList<SurgeryReservation> getSchedule() {
        return schedule;
    }

    public void setSchedule(ArrayList<SurgeryReservation> schedule) {
        this.schedule = schedule;
    }
}
