package ee.au.servicedeskrestapi.repositories;

import javax.persistence.EntityManager;

import org.springframework.data.jpa.repository.JpaRepository;

import ee.au.servicedeskrestapi.dao.Ticket;


public interface StatusesRepository extends JpaRepository<Ticket, Long> {   

}