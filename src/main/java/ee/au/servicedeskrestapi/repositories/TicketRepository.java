package ee.au.servicedeskrestapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import ee.au.servicedeskrestapi.dao.Ticket;


public interface TicketRepository extends JpaRepository<Ticket, Long>, QueryByExampleExecutor<Ticket> {
}