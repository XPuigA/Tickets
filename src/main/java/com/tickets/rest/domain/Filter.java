package com.tickets.rest.domain;

import java.util.ArrayList;
import java.util.HashSet;

public class Filter {
    public static Result filter(Tickets tickets, Result toFilter) {
        Result<Tickets> filteredResult = new Result<>();
        filteredResult.setExact(filterList(tickets, toFilter.getExact()));
        filteredResult.setBelow(filterList(tickets, toFilter.getBelow()));
        filteredResult.setBelowMargin(filterList(tickets, toFilter.getBelowMargin()));
        filteredResult.setExactMargin(filterList(tickets, toFilter.getExactMargin()));
        return filteredResult;
    }

    private static HashSet<Tickets> filterList(Tickets tickets, HashSet<ArrayList<Double>> toFilter) {
        HashSet<Tickets> filtered = new HashSet<>();
        for (ArrayList<Double> combination : toFilter) {
            Tickets ticketCombination = new Tickets(combination);
            if (tickets.isValidCombination(ticketCombination)) {
                filtered.add(ticketCombination);
            }
        }
        return filtered;
    }
}
