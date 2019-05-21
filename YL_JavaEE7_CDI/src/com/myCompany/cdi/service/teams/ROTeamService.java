package com.myCompany.cdi.service.teams;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Alternative;

@Alternative
@RequestScoped
public class ROTeamService implements FootballTeamService {

	@Override
	public String getFootballTeam() {
		return "ROMANIA";
	}

}
