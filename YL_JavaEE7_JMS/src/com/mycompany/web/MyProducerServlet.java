package com.mycompany.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Optional;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mycompany.jms.mymessage.MyMessageProducer;


@WebServlet("/MyProducerServlet")
public class MyProducerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Inject
	private MyMessageProducer messageProducer;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter responseWriter = response.getWriter();
		
		Optional<String> messageParameter = Optional.ofNullable(request.getParameter("msg"));
		if(!messageParameter.isPresent()) {
			responseWriter.println("Please add msg parameter and MyMessageProducer will send it to the queue.");
		}
		
		messageParameter.ifPresent( message -> {
			messageProducer.sendMessage(message);
			responseWriter.println("MyMessageProducer sent message: " + message);
		});
		
	}
	
}
