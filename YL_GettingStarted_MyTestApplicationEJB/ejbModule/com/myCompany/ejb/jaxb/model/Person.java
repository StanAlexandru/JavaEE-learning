package com.myCompany.ejb.jaxb.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name="human")
@XmlAccessorType(XmlAccessType.PUBLIC_MEMBER)
@XmlType(name = "individual", propOrder = {"name", "age", "gender", "occupation"})
public class Person {

	private String name;
	private int age;
	private String occupation;
	private GenderType gender;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getOccupation() {
		return occupation;
	}

	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}
	
	@XmlElement
	public GenderType getGender() {
		return gender;
	}

	public void setGender(GenderType gender) {
		this.gender = gender;
	}

	@XmlType
	@XmlEnum
	public enum GenderType {
		@XmlEnumValue("M") MALE, 
		@XmlEnumValue("F") FEMALE;
	}
}
