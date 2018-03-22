package com.tickets.gui;

import java.util.ArrayList;
import java.util.HashSet;

import javax.swing.JPanel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

import com.tickets.rest.domain.Ticket;
import com.tickets.rest.domain.Tickets;

public class ResultsTicketList extends JPanel {
	
	public ResultsTicketList() {}
	
	public void update(HashSet<Tickets> ticketResult) {
		this.invalidate();
		this.removeAll();
		ArrayList<String> opts = new ArrayList<>();
		for (Tickets tickets : ticketResult) {
			StringBuilder sb = new StringBuilder();
			for (Ticket ticket: tickets.getTickets().values()) {
				sb.append("[V: " + ticket.getValue() + " Q: " + ticket.getQuantity() + "]");
			}
			opts.add(sb.toString());
		}
		String[] listOptions = new String[opts.size()]; 
		listOptions = opts.toArray(listOptions);
		JList<String> list = new JList<>(listOptions);		
		list.setSelectionMode( ListSelectionModel.SINGLE_SELECTION );
	    list.setSelectedIndex( 0 );
		JScrollPane scroll = new JScrollPane(list);
		this.add(scroll);
		this.repaint();
	}
}
