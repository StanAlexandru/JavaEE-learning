package com.myCompany.cdi.web;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.myCompany.cdi.qualifier.EnglishMessage;
import com.myCompany.cdi.qualifier.FrenchMessage;
import com.myCompany.cdi.service.HelloService;
import com.myCompany.cdi.service.teams.FootballTeamService;

/**
 * Servlet implementation class HelloWorldServlet
 */
@WebServlet("/HelloWorldServlet")
public class HelloWorldServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;   
	
	@Inject
	@EnglishMessage
	private HelloService helloService_en;
	
	@Inject
	@FrenchMessage
	private HelloService helloService_fr;
	
	@Inject
	FootballTeamService teamService;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		response.getWriter().append("\n\n").append("HelloWorldServlet annotation qualifier: helloService_en.sayHello: " + helloService_en.sayHello());
		
		response.getWriter().append("\n\n").append("HelloWorldServlet annotation qualifier: helloService_fr.sayHello: " + helloService_fr.sayHello());
		
		response.getWriter().append("\n\n").append("HelloWorldServlet with @Alternatives: teamService.getFootballTeam(): " + teamService.getFootballTeam());
		if(teamService.getFootballTeam().equals("ROMANIA")) {
			response.getWriter().append("\n").append("We got the alternative defined in beans.xml.");
			response.getWriter().append("\n").append("If the <class> in <alternatives> is commented we get BRAZIL implementation.");
			response.getWriter().append("\n").append("BRAZIL implementation is with @Default since it doesn't have a @Alternative.");
		}
	}

}
