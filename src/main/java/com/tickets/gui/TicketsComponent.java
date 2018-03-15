package com.tickets.gui;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.tickets.rest.domain.Ticket;
import com.tickets.rest.domain.Tickets;

public class TicketsComponent extends JPanel {
	
	private static final long serialVersionUID = 1L;
	
	Tickets tickets;
	BoxLayout layout;
	
	TicketsComponent() {
		tickets = new Tickets();
		layout = new BoxLayout(this, BoxLayout.Y_AXIS);
		this.setLayout(layout);
	}
	
	public void addTicket(Ticket ticket) {
		this.tickets.add(ticket);
		this.add(new JLabel("Value: " + ticket.getValue() + " Quantity: " + ticket.getQuantity()));
		this.revalidate();
	}
}
