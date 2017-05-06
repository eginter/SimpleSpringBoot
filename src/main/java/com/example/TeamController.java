package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TeamController {

	
	@Autowired 
	TeamRepository teamRepository;
	
	  @RequestMapping("/teams")
	  public Iterable<Team> getTeams() {
	  	return teamRepository.findAll();
	  }

}
