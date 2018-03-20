package com.tickets.gui;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

import com.tickets.rest.domain.Ticket;
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
		this.removeAll();
		for (Ticket ticket: GUIController.getInstance().getTickets().getTicketList())
			this.add(new TicketComponent(ticket));
		this.revalidate();
	}
}
