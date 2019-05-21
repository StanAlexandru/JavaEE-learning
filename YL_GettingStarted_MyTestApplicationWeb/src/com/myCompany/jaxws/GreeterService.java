/**
 * GreeterService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.myCompany.jaxws;

public interface GreeterService extends javax.xml.rpc.Service {
    public java.lang.String getGreeterPortAddress();

    public com.myCompany.jaxws.Greeter getGreeterPort() throws javax.xml.rpc.ServiceException;

    public com.myCompany.jaxws.Greeter getGreeterPort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}
