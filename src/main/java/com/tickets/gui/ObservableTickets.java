package com.tickets.gui;

import com.tickets.rest.domain.Ticket;
import com.tickets.rest.domain.Tickets;

import actions.TicketsActions;

import java.util.Collection;
import java.util.Observable;

public class ObservableTickets extends Observable {
    private Tickets tickets = new Tickets();

    public void add(Ticket t) {
        tickets.add(t);
        setChanged();
        notifyObservers(TicketsActions.ADD);
    }
    
    public void remove(Ticket t) {
    	tickets.remove(t);
    	setChanged();
    	notifyObservers(TicketsActions.REMOVE);
    }

    public Tickets getTickets() {
        return tickets;
    }
    
    public Collection<Ticket> getTicketList() {
    	return this.tickets.getTickets().values();
    }
}