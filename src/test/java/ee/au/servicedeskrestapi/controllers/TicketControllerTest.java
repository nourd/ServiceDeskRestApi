package ee.au.servicedeskrestapi.controllers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import ee.au.servicedeskrestapi.dao.Ticket;
import ee.au.servicedeskrestapi.repositories.TicketRepository;


class TicketControllerTests {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private TicketRepository tickets;

	@BeforeEach
	void setup() {
        Ticket one = new Ticket();
        one.setDocumentNumber("TK-1");
		one.setStatus("open");
        Ticket two = new Ticket();
        two.setDocumentNumber("TK-2");
		two.setStatus("open");
	}

	@Test
	void testShowResourcesTicketsList() throws Exception {
		ResultActions actions = mockMvc.perform(get("/tickets").accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());
		actions.andExpect(content().contentType(MediaType.APPLICATION_JSON))
				.andExpect(jsonPath("$.tickets[0].status").value("open"));
	}

}
