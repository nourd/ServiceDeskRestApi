package ee.au.servicedeskrestapi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

import ee.au.servicedeskrestapi.collections.*;
import ee.au.servicedeskrestapi.repositories.*;
import ee.au.servicedeskrestapi.services.TicketService;
import ee.au.servicedeskrestapi.dao.*;
import ee.au.servicedeskrestapi.errorhandling.EntityNotFoundException;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "/tickets")
class TicketController {

	@Autowired
    private TicketService tickets;

	
	
	@CrossOrigin(origins = "*")
	@GetMapping({ "/tickets" })
	public @ResponseBody Tickets showResourcesTicketList() throws EntityNotFoundException {
		Tickets tickets = new Tickets();
		tickets.getTicketList().addAll(this.tickets.getAllTickets());
		return tickets;
	}

	@CrossOrigin(origins = "*")
	@GetMapping(value="/ticket/{id}")
	Ticket getTicketById(@PathVariable Integer id) throws EntityNotFoundException {
		return tickets.getById(id);
	}

	@PostMapping({"/tickets"})
    Ticket createOrSaveTicket(@RequestBody Ticket newTicket) {
		newTicket.setDocumentNumber("aaa");
        return tickets.addOrUpdate(newTicket);
	}
	/*
	@CrossOrigin(origins = "*")
	@PutMapping("/tickets/{id}")
    Ticket updateTicket(@RequestBody Ticket newTicket, @PathVariable Integer id) {
 
        return tickets.getById(id).map(ticket -> {
            ticket.setTitle(newTicket.getTitle());
            return tickets.save(ticket);
        }).orElseGet(() -> {
            newTicket.setId(id);
            return tickets.save(newTicket);
        });
	}
*/
	
	

	@DeleteMapping("/tickets/{id}")
    void deleteTicket(@PathVariable Integer id) {
        tickets.delete(id);
    }

}