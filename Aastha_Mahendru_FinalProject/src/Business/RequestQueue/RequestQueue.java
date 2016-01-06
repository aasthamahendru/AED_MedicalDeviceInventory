/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.RequestQueue;

import java.util.ArrayList;

/**
 *
 * @author Aastha
 */
public class RequestQueue {

    private ArrayList<Request> requestList;

    public RequestQueue() {
        requestList = new ArrayList<>();
    }

    public ArrayList<Request> getWorkRequestList() {
        return requestList;
    }
}
