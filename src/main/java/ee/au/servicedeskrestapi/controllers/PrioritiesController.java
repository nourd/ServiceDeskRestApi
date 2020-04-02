package ee.au.servicedeskrestapi.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import ee.au.servicedeskrestapi.collections.Priorities;
import ee.au.servicedeskrestapi.model.EnumItem;

@RestController
class PrioritiesController {

    @CrossOrigin(origins = "*")
	@GetMapping({ "/priorities" })
	public List<EnumItem> showPriorities() {	
		Priorities priorities = new Priorities();
		return priorities.getPrioritiesList();
	}

}