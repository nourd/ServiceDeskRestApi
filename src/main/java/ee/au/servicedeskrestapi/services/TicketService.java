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

@Service
public class TicketService {

    @Autowired
    TicketRepository ticketRepository;

    public List<Ticket> getAllTickets() {
        List<Ticket> tickets = new ArrayList<Ticket>();
        ticketRepository.findAll().forEach(ticket -> tickets.add(ticket));
        return tickets;
    }

    public Ticket getTicketById(int id) {
        return ticketRepository.findById(id).get();
    }

    public void saveOrUpdate(Ticket ticket) {
        ticketRepository.save(ticket);
    }

    public void delete(int id) {
        ticketRepository.deleteById(id);
    }
}