package ee.au.servicedeskrestapi.controllers;

import java.util.List;

import org.hibernate.criterion.Example;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import ee.au.servicedeskrestapi.collections.Tickets;
import ee.au.servicedeskrestapi.dao.Ticket;
import ee.au.servicedeskrestapi.repositories.TicketRepository;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "/tickets")
class TicketController {

	@Autowired
	//private TicketService tickets;
	
	TicketRepository ticketRepository;



	@CrossOrigin(origins = "*")
	@GetMapping({ "/tickets" })
	public List<Ticket> showResourcesTicketList() {
		//<Ticket>Example<Ticket> example = Example.of(Ticket.getStatus("open"));
		return ticketRepository.findAll();
		
	}

	@CrossOrigin(origins = "*")
	@GetMapping(value="/ticket/{id}")
	Ticket getTicketById(@PathVariable Long id)  {
		//return tickets.getById(id);
		return ticketRepository.findById(id).get();
	}
/*
	@CrossOrigin(origins = "*")
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
	
	
/*
	@DeleteMapping("/tickets/{id}")
    void deleteTicket(@PathVariable Long id) {
        tickets.delete(id);
    }
*/
}