package com.mycompany.web;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mycompany.remote.SecuredBeanRemote;

@WebServlet("/SecuredServlet")
public class SecuredServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@EJB
	SecuredBeanRemote securedBeanRemote;
       
    public SecuredServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("securedBeanRemote.doSecureTask -> Check server log(http://localhost:4848/management/domain/view-log) for 'SecuredBean.doSecureTask() was called!'");
		securedBeanRemote.doSecureTask();
	}

}
