package com.tickets.gui;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.tickets.rest.domain.Ticket;

public class DataIntroductionPanel extends Panel {

	private static final long serialVersionUID = 1L;

	GridBagConstraints c = new GridBagConstraints();
	
	JPanel dataPanel;
	
	JLabel wantedLabel;
	JTextField wantedField;
	JLabel marginLabel;
	JTextField marginField;
	JButton findButton;
	
	JLabel ticketValueLabel;
	JTextField ticketValueField;
	JLabel ticketQuantityLabel;
	JTextField ticketQuantityField;
	JButton newTicketButton;
	
	TicketsComponent ticketsComponent;
	
	public DataIntroductionPanel() {
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		dataPanel = new JPanel(new GridBagLayout());
		addWanted();
		addMargin();
		addFindButton();
		
		addTicketValue();
		addTicketQuantity();
		addNewTicketButton();
		
		this.add(dataPanel);
		addTicketComponent();


	}
	
	private void addTicketComponent() {
		ticketsComponent = new TicketsComponent();
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridwidth = 3;
		c.weightx = 0.5;
		c.gridx = 0;
		c.gridy = 3;
		dataPanel.add(ticketsComponent, c);
	}

	private void addTicketValue() {
		JPanel panel = new JPanel(new BorderLayout());
		ticketValueLabel = new JLabel("Ticket value: ");
		ticketValueField = new JTextField();
		ticketValueField.setColumns(3);
		panel.add(ticketValueLabel, BorderLayout.WEST);
		panel.add(ticketValueField, BorderLayout.CENTER);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 0.5;
		c.gridx = 0;
		c.gridy = 1;
		dataPanel.add(panel, c);
	}
	
	private void addTicketQuantity() {
		JPanel panel = new JPanel(new BorderLayout());
		ticketQuantityLabel = new JLabel("Ticket quantity: ");
		ticketQuantityField = new JTextField();
		ticketQuantityField.setColumns(3);
		panel.add(ticketQuantityLabel, BorderLayout.WEST);
		panel.add(ticketQuantityField, BorderLayout.CENTER);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 0.5;
		c.gridx = 1;
		c.gridy = 1;
		dataPanel.add(panel, c);
	}
	
	private void addNewTicketButton() {
		findButton = new JButton("Add ticket");
		findButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				addTicketAction();
			}
		});
		c.weightx = 0.5;
		c.gridx = 2;
		c.gridy = 1;
		dataPanel.add(findButton, c);
	}

	private void addTicketAction() {
		Ticket t = new Ticket(Double.parseDouble(ticketValueField.getText()), Integer.parseInt(ticketQuantityField.getText()));
		ticketsComponent.addTicket(t);
	}
	
	private void addWanted() {
		JPanel panel = new JPanel(new BorderLayout());
		wantedLabel = new JLabel("Wanted: ");
		wantedField = new JTextField();
		wantedField.setColumns(3);
		panel.add(wantedLabel, BorderLayout.WEST);
		panel.add(wantedField, BorderLayout.CENTER);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 0.5;
		c.gridx = 0;
		c.gridy = 0;
		dataPanel.add(panel, c);
	}
	
	private void addMargin() {
		JPanel panel = new JPanel(new BorderLayout());
		marginLabel = new JLabel("Margin: ");
		marginField = new JTextField();
		marginField.setColumns(3);
		panel.add(marginLabel, BorderLayout.WEST);
		panel.add(marginField, BorderLayout.CENTER);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 0.5;
		c.gridx = 1;
		c.gridy = 0;
		dataPanel.add(panel, c);
	}
	
	private void addFindButton() {
		findButton = new JButton("Find");
		findButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				findAction();
			}
		});
		c.weightx = 0.5;
		c.gridx = 2;
		c.gridy = 0;
		dataPanel.add(findButton, c);
	}
	
	private void findAction() {
		try {
			double wanted = Double.parseDouble(wantedField.getText());
			double margin = Double.parseDouble(marginField.getText());
			GUIController.getInstance().findCombinations(wanted, margin);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void setSize() {
		c.gridheight = this.getParent().getHeight();
		c.gridwidth = this.getParent().getWidth();
		this.repaint();
	}
}
