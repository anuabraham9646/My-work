package com.fullstack.ipl.dashboard.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fullstack.ipl.dashboard.model.Match;
import com.fullstack.ipl.dashboard.model.Team;
import com.fullstack.ipl.dashboard.repository.MatchRepository;
import com.fullstack.ipl.dashboard.repository.TeamRepository;

@RestController
@CrossOrigin
public class TeamController {
	private TeamRepository trepo;
	private MatchRepository mrepo;
	private Map<String,String> teamAbbr= new HashMap<>();
	public TeamController(TeamRepository trepo,MatchRepository mrepo) {
		this.trepo = trepo;
		this.mrepo = mrepo;
		teamAbbr.put("CSK", "Chennai Super Kings");
		teamAbbr.put("MI", "Mumbai Indians");
		teamAbbr.put("SRH", "Sunrisers Hyderabad");
		teamAbbr.put("RR", "Rajasthan Royals");
		teamAbbr.put("DC", "Delhi Capitals");
		teamAbbr.put("KXIP", "Kings XI Punjab");
		teamAbbr.put("RCB", "Royal Challengers Bangalore");
		teamAbbr.put("KKR", "Kolkata Knight Riders");
		teamAbbr.put("RPS", "Rising Pune Supergiant");
		teamAbbr.put("GL", "Gujarat Lions");
		teamAbbr.put("KTK", "Kochi Tuskers Kerala"); 
		
	}
	
	@GetMapping("/team/{teamName}")
	public Team getTeam(@PathVariable String teamName, @RequestParam("size") int pageSize) {
		String teamFullName= teamAbbr.get(teamName);
		Team team= this.trepo.findByTeamName(teamFullName);
		List<Match> lisMatch=this.mrepo.findLatestMatchesbyteam(teamFullName, pageSize);
		System.out.println(lisMatch.size());
		team.setMatches(lisMatch);
		return team;

	}
	
}
