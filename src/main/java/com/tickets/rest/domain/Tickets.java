package com.tickets.rest.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Tickets {
    private Map<Double, Ticket> tickets = new HashMap<>();
    int numberOfTickets = 0;

    public Tickets() {}

    public Tickets(JSONArray ticketList) {
    	for (int i=0; i<ticketList.length(); ++i) {
    		JSONObject ticket;
			try {
				ticket = ticketList.getJSONObject(i);
				this.add(new Ticket(ticket.getDouble("value"), ticket.getInt("quantity")));
			} catch (JSONException e) {
				e.printStackTrace();
			}
    	}
    }
    
    public Tickets(ArrayList<Double> values) {
        for (Double value : values) {
            this.add(value);
        }
    }

    public Tickets(double[] values) {
        for (double value : values) {
            this.add(value);
        }
    }

    public void add(Ticket ticket) {
        Ticket found = tickets.get(ticket.getValue());
        if (found != null) {
            found.incrementQuantity(ticket.getQuantity());            
        }
        else {
            tickets.put(ticket.getValue(), ticket.clone());
        }
        this.numberOfTickets += ticket.getQuantity();
    }

    public void add(double value) {
        Ticket found = tickets.get(value);
        if (found != null) found.incrementQuantity();
        else tickets.put(value, new Ticket(value));
        this.numberOfTickets++;
    }

    public Map<Double, Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(Map<Double, Ticket> tickets) {
        this.tickets = tickets;
    }

    public int getNumberOfTickets() {
        return numberOfTickets;
    }

    public void setNumberOfTickets(int numberOfTickets) {
        this.numberOfTickets = numberOfTickets;
    }

    public boolean isValidCombination(Tickets combination) {
        for (Map.Entry<Double, Ticket> entry : combination.getTickets().entrySet()) {
            Ticket own = this.tickets.get(entry.getKey());
            if (own == null || own.getQuantity() < entry.getValue().getQuantity())
                return false;
        }
        return true;
    }

    public double[] spreaded() {
        double[] spreadedTickets = new double[numberOfTickets];
        int index = 0;
        for (Map.Entry<Double, Ticket> entry : tickets.entrySet()) {
            for (int i=0; i<entry.getValue().getQuantity(); ++i) {
                spreadedTickets[index] = entry.getKey();
                index++;
            }
        }
        return spreadedTickets;
    }
    
    public boolean remove(Ticket t) {
    	return tickets.remove(t.getValue()) != null;
    }
}
