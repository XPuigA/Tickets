package com.tickets.gui;

import java.awt.Font;
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
	
	JPanel exactPanel;
	JPanel belowPanel;
	JPanel belowMarginPanel;
	JPanel exactMarginPanel;
	
	ResultsPanel() {
		this.setLayout(new GridBagLayout());
		GUIController.getInstance().getResult().addObserver(this);
		addLabels();
		initializePanels();
		this.revalidate();
	}
	
	private JLabel getTitleLabel(String text) {
		JLabel label = new JLabel(text);
		Font f = label.getFont();
		label.setFont(f.deriveFont(f.getStyle() | Font.BOLD));
		return label;
	}
	
	private void addLabels() {
		c.fill = GridBagConstraints.NORTHWEST;
		c.weightx = 0.5;
		c.gridx = 0;
		c.gridy = 0;
		this.add(getTitleLabel("Exact value"), c);
		
		c.fill = GridBagConstraints.NORTHEAST;
		c.weightx = 0.5;
		c.gridx = 1;
		c.gridy = 0;
		this.add(getTitleLabel("Below value"), c);
		
		c.fill = GridBagConstraints.SOUTHWEST;
		c.weightx = 0.5;
		c.gridx = 0;
		c.gridy = 2;
		this.add(getTitleLabel("Below margin"), c);
		
		c.fill = GridBagConstraints.SOUTHEAST;
		c.weightx = 0.5;
		c.gridx = 1;
		c.gridy = 2;
		this.add(getTitleLabel("Exact margin"), c);
	}

	private void initializePanels() {
		exactPanel = new JPanel();
		exactPanel.setLayout(new BoxLayout(exactPanel, BoxLayout.Y_AXIS));
		c.fill = GridBagConstraints.NORTHWEST;
		c.weightx = 0.5;
		c.gridx = 0;
		c.gridy = 1;
		this.add(exactPanel, c);
		
		belowPanel = new JPanel();
		belowPanel.setLayout(new BoxLayout(belowPanel, BoxLayout.Y_AXIS));
		c.fill = GridBagConstraints.NORTHEAST;
		c.weightx = 0.5;
		c.gridx = 1;
		c.gridy = 1;
		this.add(belowPanel, c);
		
		belowMarginPanel = new JPanel();
		belowMarginPanel.setLayout(new BoxLayout(belowMarginPanel, BoxLayout.Y_AXIS));
		c.fill = GridBagConstraints.SOUTHWEST;
		c.weightx = 0.5;
		c.gridx = 0;
		c.gridy = 3;
		this.add(belowMarginPanel, c);
		
		exactMarginPanel = new JPanel();
		exactMarginPanel.setLayout(new BoxLayout(exactMarginPanel, BoxLayout.Y_AXIS));
		c.fill = GridBagConstraints.SOUTHEAST;
		c.weightx = 0.5;
		c.gridx = 1;
		c.gridy = 3;
		this.add(exactMarginPanel, c);
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		ObservableResult result = GUIController.getInstance().getResult();
		setExact(result.getExact());
		setBelow(result.getBelow());
		setBelowMargin(result.getBelowMargin());
		setExactMargin(result.getExactMargin());
		this.revalidate();
	}

	private void fillPanel(JPanel panel, HashSet<Tickets> ticketResult) {
		panel.invalidate();
		panel.removeAll();
		for (Tickets tickets : ticketResult) {
			StringBuilder sb = new StringBuilder();
			for (Ticket ticket: tickets.getTickets().values()) {
				sb.append("[V: " + ticket.getValue() + " Q: " + ticket.getQuantity() + "]");
			}
			panel.add(new JLabel(sb.toString()));
		}
	}
	
	private void setExact(HashSet<Tickets> tickets) {
		fillPanel(exactPanel, tickets);
	}
	
	private void setBelow(HashSet<Tickets> tickets) {
		fillPanel(belowPanel, tickets);
	}
	
	private void setBelowMargin(HashSet<Tickets> tickets) {
		fillPanel(belowMarginPanel, tickets);
	}
	
	private void setExactMargin(HashSet<Tickets> tickets) {
		fillPanel(exactMarginPanel, tickets);
	}
	
}
