package com.mycompany.web;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mycompany.jms.mymessage.MyMessageConsumer;

@WebServlet("/MyConsumerServlet")
public class MyConsumerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Inject
	private MyMessageConsumer messageConsumer;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		response.getWriter().println("MyMessageConsumer received message: " + messageConsumer.receivedMessage());
	}

}
