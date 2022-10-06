package com.example.demo.Service;

import com.example.demo.DTO.Person;

import reactor.core.publisher.Flux;

public interface PersonServiceI {

	public Flux<Person> allPersons();
}
