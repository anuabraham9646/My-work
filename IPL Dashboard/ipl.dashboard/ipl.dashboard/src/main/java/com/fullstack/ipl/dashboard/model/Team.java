package com.fullstack.ipl.dashboard.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity
public class Team {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String teamName;
	private String teamAbbr;
	private long totalWins;
	private long totalMatches;
	
	@Transient
	private List<Match> matches;// basically tells jpa not to crate entry in table its for kinda like rough work purpose
	
	
	public Team() {
		super();
	}
	public Team(String teamName, String teamAbbr,long totalMatches) {
		super();
		this.teamName = teamName;
		this.teamAbbr = teamAbbr;
		this.totalMatches = totalMatches;
	}
	public String getTeamName() {
		return teamName;
	}
	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}
	public String getTeamAbbr() {
		return teamAbbr;
	}
	public void setTeamAbbr(String teamAbbr) {
		this.teamAbbr = teamAbbr;
	}
	public long getTotalWins() {
		return totalWins;
	}
	public void setTotalWins(long totalWins) {
		this.totalWins = totalWins;
	}
	public long getTotalMatches() {
		return totalMatches;
	}
	public void setTotalMatches(long totalMatches) {
		this.totalMatches = totalMatches;
	}
	@Override
	public String toString() {
		return "Team [teamName=" + teamName + ", teamAbbr=" + teamAbbr +", totalWins=" + totalWins + ", totalMatches=" + totalMatches + "]";
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public List<Match> getMatches() {
		return matches;
	}
	public void setMatches(List<Match> matches) {
		this.matches = matches;
	}
}
