package ee.au.servicedeskrestapi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import ee.au.servicedeskrestapi.collections.Statuses;
import ee.au.servicedeskrestapi.model.EnumItem;

@RestController
class StatusesController {

    @CrossOrigin(origins = "*")
	@GetMapping({ "/statuses" })
	public List<EnumItem> showStatuses() {	
		Statuses statuses = new Statuses();
		return statuses.getStatusesList();
	}

}