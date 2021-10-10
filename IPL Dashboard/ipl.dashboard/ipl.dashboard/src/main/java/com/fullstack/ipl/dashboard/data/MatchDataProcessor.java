package com.fullstack.ipl.dashboard.data;

import java.time.LocalDate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;

import com.fullstack.ipl.dashboard.model.Match;

public class MatchDataProcessor implements ItemProcessor<MatchInput, Match> {

	  private static final Logger log = LoggerFactory.getLogger(MatchDataProcessor.class);

	  @Override
	  public Match process(final MatchInput matchInput) throws Exception {

	    Match match = new Match();
	    match.setId(Long.parseLong(matchInput.getId()));
	    match.setCity(matchInput.getCity());

        match.setDate(LocalDate.parse(matchInput.getDate()));

        match.setPlayerOfMatch(matchInput.getPlayer_of_match());
        match.setVenue(matchInput.getVenue());
        
        String firstTeam,secondTeam;
        // Set Team 1 and Team 2 depending on the innings order
        if("bat".equalsIgnoreCase(matchInput.getToss_decision())) {
        	firstTeam= matchInput.getToss_winner();
        	secondTeam= matchInput.getToss_winner().equalsIgnoreCase(matchInput.getTeam1())?matchInput.getTeam2():matchInput.getTeam1();
        }
        else {
        	firstTeam= matchInput.getToss_winner().equalsIgnoreCase(matchInput.getTeam1())?matchInput.getTeam2():matchInput.getTeam1();
        	secondTeam= matchInput.getToss_winner();
        }
        match.setTeam1(firstTeam);
        match.setTeam2(secondTeam);
        match.setTossWinner(matchInput.getToss_winner());
        match.setTossDecision(matchInput.getToss_decision());
        match.setMatchWinner(matchInput.getWinner());
        match.setResult(matchInput.getResult());
        match.setResultMargin(matchInput.getResult_margin());
        match.setUmpire1(matchInput.getUmpire1());
        match.setUmpire2(matchInput.getUmpire2());

	    return match;
	  }

	}
