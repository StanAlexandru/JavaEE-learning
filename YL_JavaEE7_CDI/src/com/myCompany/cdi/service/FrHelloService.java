package com.myCompany.cdi.service;

import javax.enterprise.context.RequestScoped;

import com.myCompany.cdi.qualifier.FrenchMessage;

@RequestScoped
@FrenchMessage
public class FrHelloService implements HelloService {

	@Override
	public String sayHello() {
		return "Bonjour le Monde!!!";
	}

}
