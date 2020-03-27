package ee.au.servicedeskrestapi.dao;

import org.junit.jupiter.api.Test;
import org.springframework.util.SerializationUtils;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDate;

class TicketTests {

	@Test
	void testSerialization() {
        Ticket ticket = new Ticket();
        ticket.setTitle("Some problem");
        ticket.setDocumentNumber("TK-10");
        ticket.setDocumentDate(LocalDate.parse("2020-03-24"));
        ticket.setEmail("a@a.ee");
		ticket.setId(10);
		Ticket other = (Ticket) SerializationUtils.deserialize(SerializationUtils.serialize(ticket));
        assertThat(other.getTitle()).isEqualTo(ticket.getTitle());
		assertThat(other.getId()).isEqualTo(ticket.getId());
	}

}