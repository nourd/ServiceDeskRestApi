package ee.au.servicedeskrestapi.controllers;

import java.util.List;

import javax.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import ee.au.servicedeskrestapi.dao.Ticket;
import ee.au.servicedeskrestapi.repositories.TicketRepository;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "/tickets")
class TicketController {

	@Autowired
	
	TicketRepository ticketRepository;

	@CrossOrigin(origins = "*")
	@GetMapping({ "/tickets" })
	public List<Ticket> showResourcesTicketList() {
		Ticket openTicket = new Ticket();
		openTicket.setStatus("open");
		Example<Ticket> openExample = Example.of(openTicket);
		
		return ticketRepository.findAll(openExample, Sort.by(Sort.Direction.DESC, "documentDate"));	
	}

	@CrossOrigin(origins = "*")
	@GetMapping(value="/ticket/{id}")
	Ticket getTicketById(@PathVariable Long id, HttpServletResponse response)  {
		//return tickets.getById(id);
		try {
			return ticketRepository.findById(id).get();
		}
		catch (MyResourceNotFoundException exc) {
			throw new ResponseStatusException(
			  HttpStatus.NOT_FOUND, "Ticket Not Found", exc);
	   }
		
		
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