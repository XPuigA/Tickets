package com.tickets.rest.domain;

import java.util.ArrayList;

public class Finder {

    public static Result find(double wantedValue, double margin, Tickets allowedTickets) {
        Result result = Combinator.combine(wantedValue, margin, allowedTickets.spreaded());
        result = Filter.filter(allowedTickets, result);
        return result;
    }
}
