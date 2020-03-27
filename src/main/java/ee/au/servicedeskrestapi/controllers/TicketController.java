package ee.au.servicedeskrestapi.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

import ee.au.servicedeskrestapi.collections.*;
import ee.au.servicedeskrestapi.repositories.*;
import ee.au.servicedeskrestapi.dao.*;


@Controller
class TicketController {

	private final TicketRepository tickets;

	public TicketController(TicketRepository ticketService) {
		this.tickets = ticketService;
	}

	
	//@CrossOrigin(origins = "*")
	@GetMapping({ "/tickets" })
	public @ResponseBody Tickets showResourcesTicketList() {
		Tickets tickets = new Tickets();
		tickets.getTicketList().addAll(this.tickets.findAll());
		return tickets;
	}

	

}