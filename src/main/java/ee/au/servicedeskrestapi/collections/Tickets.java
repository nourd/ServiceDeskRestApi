package ee.au.servicedeskrestapi.collections;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import ee.au.servicedeskrestapi.dao.*;

@XmlRootElement
public class Tickets {

	private List<Ticket> tickets;

	@XmlElement
	public List<Ticket> getTicketList() {
		if (tickets == null) {
			tickets = new ArrayList<>();
		}
		return tickets;
	}

}