package com.tickets.gui;

import java.util.HashSet;
import java.util.Observable;

import com.tickets.rest.domain.Result;
import com.tickets.rest.domain.Tickets;

public class ObservableResult extends Observable {
	private Result<Tickets> result;
	
	public void setResult(Result<Tickets> result) {
		this.result = result;
		this.setChanged();
		this.notifyObservers();
	}
	
	public HashSet<Tickets> getExact() {
		return result.getExact();
	}
	
	public HashSet<Tickets> getBelow() {
		return result.getBelow();
	}
	
	public HashSet<Tickets> getBelowMargin() {
		return result.getBelowMargin();
	}
	
	public HashSet<Tickets> getExactMargin() {
		return result.getExactMargin();
	}
}
