package ee.au.servicedeskrestapi.repositories;

import java.util.Collection;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.dao.DataAccessException;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;
import org.springframework.transaction.annotation.Transactional;

import ee.au.servicedeskrestapi.dao.*;


public interface TicketRepository extends CrudRepository<Ticket, Integer> {

	@Transactional(readOnly = true)
	Collection<Ticket> findAll() throws DataAccessException;

}