package ee.au.servicedeskrestapi.controllers;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.assertj.core.util.Lists;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import ee.au.servicedeskrestapi.dao.Ticket;
import ee.au.servicedeskrestapi.repositories.TicketRepository;

@WebMvcTest(TicketController.class)
class TicketControllerTests {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private TicketRepository tickets;

	@BeforeEach
	void setup() {
		Ticket firstTicket = new Ticket();
		firstTicket.setTitle("Test Ticket");
		firstTicket.setId(1);
		Ticket secondTicket = new Ticket();
		secondTicket.setTitle("Test Ticket 2");
		secondTicket.setId(2);
		given(this.tickets.findAll()).willReturn(Lists.newArrayList(firstTicket, secondTicket));
	}

	

	@Test
	void testShowResourcesTicketList() throws Exception {
		ResultActions actions = mockMvc.perform(get("/tickets").accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());
		actions.andExpect(content().contentType(MediaType.APPLICATION_JSON))
				.andExpect(jsonPath("$.ticketList[0].id").value(1));
	}

}