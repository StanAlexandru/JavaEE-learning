package com.mycompany.concurrent.ejb;

import javax.ejb.Local;

@Local
public interface DataReturnBeanLocal {
	void printData();
}
