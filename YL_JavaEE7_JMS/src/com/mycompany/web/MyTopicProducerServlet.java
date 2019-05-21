package com.mycompany.web;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mycompany.jms.mymessage.MyTopicMessageProducer;

/**
 * Servlet implementation class MyTopicProducerServlet
 */
@WebServlet("/MyTopicProducerServlet")
public class MyTopicProducerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Inject
	MyTopicMessageProducer topicMessageProducer;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyTopicProducerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		topicMessageProducer.sendMessage(request.getParameter("msg"));
		response.getWriter().append("topicMessageProducer sends: ").append(request.getParameter("msg"));
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
