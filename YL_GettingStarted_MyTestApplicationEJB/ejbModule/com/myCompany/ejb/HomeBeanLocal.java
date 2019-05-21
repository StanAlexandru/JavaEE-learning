package com.myCompany.ejb;

import java.io.OutputStream;

import javax.ejb.Local;

@Local
public interface HomeBeanLocal {
	
	public OutputStream getPersonAsOutput();

}
