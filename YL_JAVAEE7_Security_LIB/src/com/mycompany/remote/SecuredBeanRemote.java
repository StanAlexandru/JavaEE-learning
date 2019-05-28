package com.mycompany.remote;

import javax.ejb.Remote;

@Remote
public interface SecuredBeanRemote {
	void doSecureTask();
}
