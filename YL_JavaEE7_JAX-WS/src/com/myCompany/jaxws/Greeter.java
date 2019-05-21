package com.myCompany.jaxws;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import com.myCompany.jaxws.model.Person;
import com.myCompany.jaxws.model.Person.GenderType;

@WebService
public class Greeter {

	public Greeter() {
		
	}
	
	@WebMethod
	public String greetWorld() {
		return "Hello World!";
	}

	@WebMethod(operationName="greetMe")
	public String greetName(
			@WebParam(name = "myName") String name) {
		return "Hello " + name + "!";
	}
	
	@WebMethod
	public Person showPerson(String name, int age, String occupation, GenderType gender) {
		Person p = new Person();
		p.setName(name);
		p.setAge(age);
		p.setOccupation(occupation);
		p.setGender(gender);
		return p;
	}
}
