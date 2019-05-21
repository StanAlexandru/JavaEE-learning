package com.myCompany.web;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.myCompany.ejb.HomeBeanRemote;

/**
 * Servlet implementation class PersonServlet
 */
@WebServlet("/PersonServletRemoteEJB")
public class PersonServletRemoteEJB extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@EJB(lookup = "java:app/YL_GettingStarted_MyTestApplicationEJB/HomeBean!com.myCompany.ejb.HomeBeanRemote")
	HomeBeanRemote homeBean;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PersonServletRemoteEJB() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Remote EJB and @EJB: ")
							.append(homeBean.getPersonAsOutput().toString());
	}

}
