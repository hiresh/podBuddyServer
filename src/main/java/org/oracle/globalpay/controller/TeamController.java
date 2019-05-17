package org.oracle.globalpay.controller;

import java.util.List;

import org.oracle.globalpay.model.Team;
import org.oracle.globalpay.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TeamController {

	@Autowired
	TeamService teamService;
	
	@GetMapping(value="/teams")
	public List<Team> getAllTeams() {
		return teamService.getAllTeams();
	}
	
}
