package com.mycompany.concurrent.web;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mycompany.concurrent.ejb.DataReturnBeanLocal;

@WebServlet("/DataServlet")
public class DataServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Inject
	private DataReturnBeanLocal dataReturnBean;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		dataReturnBean.printData();
		
		response.getWriter().append("dataReturnBean.printData() was called. Check server console!"
				+ " The messages from printData will appear after below "
				+ "\"dataReturnBean.printData() was called\""
				+ " because printData is async");
		System.out.println("dataReturnBean.printData() was called");
		
	}


}
