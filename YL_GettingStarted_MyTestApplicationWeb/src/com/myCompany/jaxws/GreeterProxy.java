package com.myCompany.jaxws;

public class GreeterProxy implements com.myCompany.jaxws.Greeter {
  private String _endpoint = null;
  private com.myCompany.jaxws.Greeter greeter = null;
  
  public GreeterProxy() {
    _initGreeterProxy();
  }
  
  public GreeterProxy(String endpoint) {
    _endpoint = endpoint;
    _initGreeterProxy();
  }
  
  private void _initGreeterProxy() {
    try {
      greeter = (new com.myCompany.jaxws.GreeterServiceLocator()).getGreeterPort();
      if (greeter != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)greeter)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)greeter)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (greeter != null)
      ((javax.xml.rpc.Stub)greeter)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public com.myCompany.jaxws.Greeter getGreeter() {
    if (greeter == null)
      _initGreeterProxy();
    return greeter;
  }
  
  public java.lang.String greetWorld() throws java.rmi.RemoteException{
    if (greeter == null)
      _initGreeterProxy();
    return greeter.greetWorld();
  }
  
  
}