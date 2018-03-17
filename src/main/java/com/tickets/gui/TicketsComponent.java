package com.tickets.gui;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.tickets.rest.domain.Ticket;
import com.tickets.rest.domain.Tickets;

import java.util.Observable;
import java.util.Observer;

public class TicketsComponent extends JPanel implements Observer {
	
	private static final long serialVersionUID = 1L;
	
	BoxLayout layout;
	
	TicketsComponent() {
		layout = new BoxLayout(this, BoxLayout.Y_AXIS);
		this.setLayout(layout);
		GUIController.getInstance().getTickets().addObserver(this);
	}
	
	public void addTicket(Ticket ticket) {
		GUIController.getInstance().getTickets().add(ticket);
	}

	@Override
	public void update(Observable o, Object arg) {
		Ticket ticket = (Ticket)arg;
		this.add(new JLabel("Value: " + ticket.getValue() + " Quantity: " + ticket.getQuantity()));


	}
}
