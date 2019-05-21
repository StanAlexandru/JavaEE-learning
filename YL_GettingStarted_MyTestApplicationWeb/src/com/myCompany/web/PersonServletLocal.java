package com.myCompany.web;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.myCompany.ejb.HomeBeanLocal;

/**
 * Servlet implementation class PersonServlet
 */
@WebServlet("/PersonServletLocal")
public class PersonServletLocal extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Inject
	HomeBeanLocal homeBean;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PersonServletLocal() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/xml; charset=utf-8");
		response.getWriter().append(homeBean.getPersonAsOutput().toString());
	}

}
