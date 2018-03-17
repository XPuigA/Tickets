package com.tickets.gui;

import com.tickets.rest.domain.Finder;
import com.tickets.rest.domain.Result;

public class GUIController {
	private ObservableTickets tickets;
	private ObservableResult result;
	private static GUIController instance;
	
	
	private GUIController() {
		tickets = new ObservableTickets();
		result = new ObservableResult();
	}
	
	public static GUIController getInstance() {
		if (instance == null) {
			instance = new GUIController();
		}
		return instance;
	}
	
	public ObservableTickets getTickets() {
		return tickets;
	}

	public void findCombinations(double wantedValue, double margin) {
		result.setResult(Finder.find(wantedValue, margin, tickets.getTickets()));
	}

	public ObservableResult getResult() {
		return result;
	}
}
