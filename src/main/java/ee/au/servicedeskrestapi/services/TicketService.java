package ee.au.servicedeskrestapi.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import ee.au.servicedeskrestapi.repositories.*;
import ee.au.servicedeskrestapi.dao.*;
import ee.au.servicedeskrestapi.errorhandling.EntityNotFoundException;

@Service
public class TicketService {
/*
    @Autowired
    private TicketRepository birdRepository;
/*
    public Bird getBirdNoException(Long birdId) {
        return birdRepository.findOne(birdId);
    }
*/
    @Autowired
    TicketRepository ticketRepository;

    public List<Ticket> getAllTickets() {
        List<Ticket> tickets = new ArrayList<Ticket>();
        ticketRepository.findAll().forEach(ticket -> tickets.add(ticket));
        return tickets;
    }

    public Ticket getById(Integer id) {
        Ticket ticket;
        ticket =  ticketRepository.findById(id).get();
        if (ticket == null) {
            throw new EntityNotFoundException(Ticket.class, "id", id.toString());
        }
        return ticket;
    }

    public Ticket addOrUpdate(Ticket ticket) {
        return ticketRepository.save(ticket);
    }

    public void delete(Integer id) {
        ticketRepository.deleteById(id);
    }
}