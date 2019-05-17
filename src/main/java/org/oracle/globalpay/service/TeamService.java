package org.oracle.globalpay.service;

import java.util.List;

import org.oracle.globalpay.model.Team;
import org.oracle.globalpay.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeamService {
	@Autowired
	UtilityService utilityService;
	
	@Autowired
	TeamRepository teamMongoRepo;
	
	public void addTeam(Team t){
		 teamMongoRepo.save(t);
	}
	
	public List<Team> getAllTeams(){
		return teamMongoRepo.findAll();
	}
}
