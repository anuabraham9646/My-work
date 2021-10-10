package com.fullstack.ipl.dashboard.repository;

import org.springframework.data.repository.CrudRepository;

import com.fullstack.ipl.dashboard.model.Team;

public interface TeamRepository extends CrudRepository<Team	, Long>{
	
	Team findByTeamName(String teamName);

}
