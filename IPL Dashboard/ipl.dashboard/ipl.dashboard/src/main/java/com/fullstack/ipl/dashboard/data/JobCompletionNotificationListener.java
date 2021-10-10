package com.fullstack.ipl.dashboard.data;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.listener.JobExecutionListenerSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fullstack.ipl.dashboard.model.Team;

@Component
public class JobCompletionNotificationListener extends JobExecutionListenerSupport {

	private static final Logger log = LoggerFactory.getLogger(JobCompletionNotificationListener.class);

	private final EntityManager em;
	private Map<String,String> teamAbbr= new HashMap<>();
	@Autowired
	public JobCompletionNotificationListener(EntityManager em) {
		this.em = em;
		teamAbbr.put("Chennai Super Kings","CSK");
		teamAbbr.put("Mumbai Indians","MI" );
		teamAbbr.put("Sunrisers Hyderabad","SRH" );
		teamAbbr.put("Rajasthan Royals","RR" );
		teamAbbr.put("Delhi Capitals","DC" );
		teamAbbr.put("Kings XI Punjab","KXIP" );
		teamAbbr.put("Royal Challengers Bangalore","RCB" );
		teamAbbr.put("Kolkata Knight Riders","KKR" );
		teamAbbr.put("Rising Pune Supergiant","RPS" );
		teamAbbr.put("Gujarat Lions","GL" );
		teamAbbr.put("Kochi Tuskers Kerala","KTK" );
	}

	@Override
	@Transactional
	public void afterJob(JobExecution jobExecution) {
		if (jobExecution.getStatus() == BatchStatus.COMPLETED) {
			log.info("!!! JOB FINISHED! Time to verify the results");

		}
		Map<String,Team> teamData= new HashMap<>();
		em.createQuery("SELECT m.team1 ,count(*) from Match m group by m.team1",Object[].class)
		.getResultList()
		.forEach(match ->{
			String teamname=(String)match[0];
			String teamAbbrev=teamAbbr.get(teamname) ;
			Team team=new Team((String)match[0],teamAbbrev,(Long)match[1]);
			teamData.put(teamname, team);
		});
		em.createQuery("SELECT m.team2 ,count(*) from Match m group by m.team2",Object[].class)
		.getResultList()
		.forEach(match ->{
			String teamname=(String)match[0];
			Team team=teamData.get(teamname);
			long teamMatchPrev= team.getTotalMatches();  //new Team((String)match[0],(Long)match[1]);
			long totalMatch=teamMatchPrev+(Long)match[1];
			team.setTotalMatches(totalMatch);
		});
		
		em.createQuery("SELECT m.matchWinner ,count(*) from Match m group by m.matchWinner",Object[].class)
		.getResultList()
		.forEach(match ->{
			String teamname=(String)match[0];
			Team team=teamData.get(teamname);
			if(null != team) team.setTotalWins((long)match[1]);
		});
		
		teamData.values().forEach(team -> em.persist(team));
		teamData.values().forEach(team -> System.out.println(team));
	}
}
