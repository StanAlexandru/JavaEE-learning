package com.mycompany.concurrent.ejb;

import java.util.concurrent.Future;

import javax.ejb.Local;

@Local
public interface DataReturnBeanLocal {
	
	void printData();
	
	Future<String> getData();
	
}
