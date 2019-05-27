package com.mycompany.concurrent.web;

import java.io.IOException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

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
		
		//////////////////////////////
		System.out.println("async without return");
		dataReturnBean.printData();
		
		response.getWriter().append("dataReturnBean.printData() was called. Check server console!"
				+ " The messages from printData will appear after below "
				+ "\"dataReturnBean.printData() was called\""
				+ " because printData is async");
		System.out.println("dataReturnBean.printData() was called");
		
		//////////////////////////////
		System.out.println("async with return");
		long tStart = System.currentTimeMillis();
		Future<String> data = dataReturnBean.getData();
		System.out.println("do some other process");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		try {
			System.out.println("data.get() returns: " + data.get());
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
		long tEnd = System.currentTimeMillis();
		double elapsedSeconds = (tEnd - tStart);
		response.getWriter().append("\n\n").append("dataReturnBean.getData() took "
				+ elapsedSeconds + "seconds to process. "
						+ "data.get() takes 5 seconds, is async and returns data!!! Check server console!");
		
		//////////////////////////////
		System.out.println("Concurrency Utilities for JAVA EE: https://docs.oracle.com/javaee/7/tutorial/concurrency-utilities.htm");
	}

}
