package com.myCompany.ejb.service;

import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebService;

@Stateless
@WebService(serviceName="Calculator")
public class CalculatorService {

	public CalculatorService() {
		
	}
	
	@WebMethod
	public int add(int a, int b) {
		return a + b;
	}
}
