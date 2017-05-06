package com.example;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.dao.TeamRepository;
import com.example.entities.Player;
import com.example.entities.Team;

@SpringBootApplication
public class SimpleSpringBootApplication {

	@Autowired
	TeamRepository teamRepository;

	public static void main(String[] args) {
		SpringApplication.run(SimpleSpringBootApplication.class, args);
	}

	@PostConstruct
	public void init() {
		List<Team> teams = new ArrayList<>();

		Set<Player> players = new HashSet<>();
		players.add(new Player("Big Easy", "Showman"));
		players.add(new Player("Buckets", "Guard"));
		players.add(new Player("Dizzy", "Guard"));

		teams.add(new Team("Harlem", "Globetrotters", players));
		teams.add(new Team("Washington", "Generals", null));

		teamRepository.save(teams);
	}
}
