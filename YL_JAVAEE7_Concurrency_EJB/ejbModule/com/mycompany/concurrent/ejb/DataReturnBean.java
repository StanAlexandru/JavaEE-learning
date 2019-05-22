package com.mycompany.concurrent.ejb;

import javax.ejb.Asynchronous;
import javax.ejb.Stateless;

@Stateless(name = "DataReturnBean")
@Asynchronous
public class DataReturnBean implements DataReturnBeanLocal{

	public DataReturnBean() {
		super();
	}

	@Override
	public void printData() {
		System.out.println("Data printing started...");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Data is printed out.");
	}
}
