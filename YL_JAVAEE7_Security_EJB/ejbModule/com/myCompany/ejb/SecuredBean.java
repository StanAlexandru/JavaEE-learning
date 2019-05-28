package com.myCompany.ejb;

import javax.annotation.security.RolesAllowed;
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
    @Override
    @RolesAllowed("MANAGER")//javax.ejb.EJBAccessException
    public void doSecureTask() {
        System.out.println("SecuredBean.doSecureTask() was called!");
    }

}
