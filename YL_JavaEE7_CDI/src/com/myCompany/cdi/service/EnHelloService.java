package com.myCompany.cdi.service;

import javax.enterprise.context.RequestScoped;

import com.myCompany.cdi.qualifier.EnglishMessage;

@RequestScoped
@EnglishMessage
public class EnHelloService implements HelloService{

	@Override
	public String sayHello() {
		return "Hello in English!";
	}

}
