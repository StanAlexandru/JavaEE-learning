package com.myCompany.ejb;

import javax.ejb.Stateless;

import com.mycompany.remote.SecuredBeanRemote;

/**
 * Session Bean implementation class SecuredBean
 */
@Stateless(mappedName = "SecuredBean")
public class SecuredBean implements SecuredBeanRemote {

    /**
     * Default constructor. 
     */
    public SecuredBean() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see SecuredBeanRemote#doSecureTask()
     */
    public void doSecureTask() {
        System.out.println("SecuredBean.doSecureTask() was called!");
    }

}
