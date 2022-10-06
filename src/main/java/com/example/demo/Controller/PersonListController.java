package com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.DTO.Person;
import com.example.demo.Service.PersonServiceI;

import reactor.core.publisher.Flux;

@Controller
public class PersonListController {

	@Autowired
	PersonServiceI personService;
	
	@GetMapping("/person-list")
	public String personList(final Model model) {
		final Flux<Person> personlist = personService.allPersons();
		model.addAttribute("personlist", personlist);
		return "personList";
	}
}
