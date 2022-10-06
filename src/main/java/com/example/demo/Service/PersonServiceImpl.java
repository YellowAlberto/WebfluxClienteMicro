package com.example.demo.Service;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.example.demo.DTO.Person;

import reactor.core.publisher.Flux;

@Service
public class PersonServiceImpl implements PersonServiceI{

	@Override
	public Flux<Person> allPersons() {
		WebClient webClient = WebClient.create("http://localhost:8080");
		Flux<Person> persons1 = webClient.get()
		        .uri("/person-list-1")
		        .retrieve()
		        .bodyToFlux(Person.class);
		
		Flux<Person> persons2 = webClient.get()
		        .uri("/person-list-2")
		        .retrieve()
		        .bodyToFlux(Person.class);
		
		Flux<Person> persons3 = webClient.get()
		        .uri("/person-list-3")
		        .retrieve()
		        .bodyToFlux(Person.class);
		
		Flux<Person> persons4 = webClient.get()
		        .uri("/person-list-4")
		        .retrieve()
		        .bodyToFlux(Person.class);
		
		Flux<Person> allPersons = Flux.concat(persons1,persons2, persons3, persons4);
		allPersons.subscribe(person->System.out.println(person.getLastname()+", "+person.getFirstname()+" tiene " + person.getAge()));
		return allPersons;
	}

}
