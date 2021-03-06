package com.fullstack.ipl.dashboard.repository;

import java.util.List;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import com.fullstack.ipl.dashboard.model.Match;

public interface MatchRepository extends CrudRepository<Match, Long> {
	
	List<Match> getByTeam1OrTeam2OrderByDateDesc(String team1, String team2,Pageable pageable);
	
	default List<Match> findLatestMatchesbyteam(String teamName,int count){
		return getByTeam1OrTeam2OrderByDateDesc(teamName,teamName,PageRequest.of(0, count));
	}
}
