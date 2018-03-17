package com.tickets.gui;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.HashSet;
import java.util.Observable;
import java.util.Observer;

import javax.swing.*;

import com.tickets.rest.domain.Ticket;
import com.tickets.rest.domain.Tickets;

public class ResultsPanel extends JPanel implements Observer {

	GridBagConstraints c = new GridBagConstraints();
	
	ResultsPanel() {
		this.setLayout(new GridBagLayout());
		GUIController.getInstance().getResult().addObserver(this);
		c.gridheight = 2;
		c.gridwidth = 2;
	}
	
	@Override
	public void update(Observable arg0, Object arg1) {
		ObservableResult result = GUIController.getInstance().getResult();
		this.removeAll();
		setExact(result.getExact());
		setBelow(result.getBelow());
		setBelowMargin(result.getBelowMargin());
		setExactMargin(result.getExactMargin());
		this.revalidate();
	}

	private JPanel getResultPanel(HashSet<Tickets> ticketResult) {
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		for (Tickets tickets : ticketResult) {
			StringBuilder sb = new StringBuilder();
			for (Ticket ticket: tickets.getTickets().values()) {
				sb.append("[V: " + ticket.getValue() + " Q: " + ticket.getQuantity() + "]");
			}
			panel.add(new JLabel(sb.toString()));
		}
		return panel;
	}
	
	private void setExact(HashSet<Tickets> tickets) {
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 0.5;
		c.gridx = 0;
		c.gridy = 0;
		this.add(getResultPanel(tickets), c);
	}
	
	private void setBelow(HashSet<Tickets> tickets) {
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 0.5;
		c.gridx = 1;
		c.gridy = 0;
		this.add(getResultPanel(tickets), c);
	}
	
	private void setBelowMargin(HashSet<Tickets> tickets) {
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 0.5;
		c.gridx = 0;
		c.gridy = 1;
		this.add(getResultPanel(tickets), c);
	}
	
	private void setExactMargin(HashSet<Tickets> tickets) {
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 0.5;
		c.gridx = 1;
		c.gridy = 1;
		this.add(getResultPanel(tickets), c);
	}
	
}
