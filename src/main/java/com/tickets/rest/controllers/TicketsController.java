package com.tickets.rest.controllers;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.tickets.rest.domain.Finder;
import com.tickets.rest.domain.Result;
import com.tickets.rest.domain.Ticket;
import com.tickets.rest.domain.Tickets;

@RestController
public class TicketsController {
	@CrossOrigin
	@PostMapping("/combinations")
	public String getCombinations(@RequestParam("tickets") String ticketsJSON, @RequestParam("wanted") Double wantedValue, @RequestParam("margin") Double margin) {
		return getTickets(ticketsJSON, wantedValue, margin);
	}
	
	@CrossOrigin
	@GetMapping("/combinations")
	public ModelAndView getCombinations() {
        ModelAndView mv = new ModelAndView("index");
        mv.addObject("tickets", "test text" );
        return mv;
	}
	
	private String getTickets(String ticketsJSON, Double wantedValue, Double margin) {
		try {
			Tickets tickets = new Tickets(new JSONArray(ticketsJSON));
			Result<Tickets> result = Finder.find(wantedValue, margin, tickets);
			Gson gson = new Gson();
			String r = "{\"exact\": [";
			int index = 0;
			for (Tickets t : result.getExact()) {
				r += gson.toJson(t.getTickets().values());
				index++;
				if (index<result.getExact().size()) r+=",";
			}
			r += "], \"below\": [";
		
			index = 0;
			for (Tickets t : result.getBelow()) {
				r += gson.toJson(t.getTickets().values());
				index++;
				if (index<result.getBelow().size()) r+=",";
			}
			r += "], \"belowMargin\": [";
		
			index = 0;
			for (Tickets t : result.getBelowMargin()) {
				r += gson.toJson(t.getTickets().values());
				index++;
				if (index<result.getBelowMargin().size()) r+=",";
			}
			r += "], \"exactMargin\": [";
			
			index = 0;
			for (Tickets t : result.getExactMargin()) {
				r += gson.toJson(t.getTickets().values());
				index++;
				if (index<result.getExactMargin().size()) r+=",";
			}
			
			r+="]}";
			
			return r;
		} catch (JSONException e) {
			e.printStackTrace();
			return ("{error: " + e.getMessage());
		}
	}
}
