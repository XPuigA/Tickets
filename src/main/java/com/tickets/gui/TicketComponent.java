package com.tickets.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.tickets.rest.domain.Ticket;

public class TicketComponent extends JPanel {
	
	Ticket ticket;
	JLabel label;
	JButton removeButton;
	
	public TicketComponent(Ticket ticket) {
		this.ticket = ticket;
		addLabel(ticket.getValue(), ticket.getQuantity());
		addRemoveButton();
	}
	
	private void addRemoveButton() {
		removeButton = new JButton("Remove");
		removeButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				removeTicketAction();
			}
		});
		
		this.add(removeButton);
	}

	private void addLabel(double value, int quantity) {
		label = new JLabel("Value: " + ticket.getValue() + " Quantity: " + ticket.getQuantity());
		this.add(label);
	}
	
	private void removeTicketAction() {
		GUIController.getInstance().getTickets().remove(ticket);
		
	}
}
