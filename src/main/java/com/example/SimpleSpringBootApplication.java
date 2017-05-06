package com.example;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SimpleSpringBootApplication {

	@Autowired
	TeamRepository teamRepository;

	public static void main(String[] args) {
		SpringApplication.run(SimpleSpringBootApplication.class, args);
	}

	@PostConstruct
	public void init() {
		List<Team> list = new ArrayList<>();

		/**
		 * initialize a couple in memory Team objects.
		 */
		Team team = new Team();
		team.setLocation("Harlem");
		team.setName("Globetrotters");
		list.add(team);

		team = new Team();
		team.setLocation("Washington");
		team.setName("Generals");
		list.add(team);

		teamRepository.save(list);
	}
}
