package com.tickets.gui;

import com.tickets.rest.domain.Ticket;
import com.tickets.rest.domain.Tickets;

import java.util.Observable;

public class ObservableTickets extends Observable {
    private Tickets tickets = new Tickets();

    public void add(Ticket t) {
        tickets.add(t);
        setChanged();
        notifyObservers(t);
    }

    public Tickets getTickets() {
        return tickets;
    }
}