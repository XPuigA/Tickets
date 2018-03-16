package com.tickets.gui;

import com.tickets.rest.domain.Finder;
import com.tickets.rest.domain.Result;
import com.tickets.rest.domain.Tickets;

public class GUIController {
	private Tickets tickets;
	private static GUIController instance;
	private Result result;
	
	private GUIController() {
		tickets = new Tickets();
	}
	
	public static GUIController getInstance() {
		if (instance == null) {
			instance = new GUIController();
		}
		return instance;
	}
	
	public Tickets getTickets() {
		return tickets;
	}

	public void findCombinations(double wantedValue, double margin) {
		result = Finder.find(wantedValue, margin, tickets);
	}
}
