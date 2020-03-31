package ee.au.servicedeskrestapi.controllers;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import ee.au.servicedeskrestapi.dao.Ticket;
import ee.au.servicedeskrestapi.exceptions.MyResourceNotFoundException;
import ee.au.servicedeskrestapi.repositories.TicketRepository;


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
		try {
			return ticketRepository.findById(id).get();
		}
		catch (MyResourceNotFoundException exc) {
			throw new ResponseStatusException(
			  HttpStatus.NOT_FOUND, "Ticket Not Found", exc);
	   }
	}

	@CrossOrigin(origins = "*")
	@PostMapping({"/tickets"})
    Ticket createOrSaveTicket(@RequestBody Ticket newTicket) {
		return ticketRepository.save(newTicket);
	}
	
	@CrossOrigin(origins = "*")
	@PutMapping("/tickets/{id}")
    Ticket updateTicket(@RequestBody Ticket newTicket, @PathVariable Integer id) {
		return ticketRepository.save(newTicket);
	}
	
	@CrossOrigin(origins = "*")
	@DeleteMapping("/tickets/{id}")
    void deleteTicket(@PathVariable Long id) {
        ticketRepository.deleteById(id);
    }
}