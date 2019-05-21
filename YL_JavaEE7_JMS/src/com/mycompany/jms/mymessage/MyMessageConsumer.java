package com.mycompany.jms.mymessage;

import javax.annotation.Resource;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.jms.JMSContext;
import javax.jms.Queue;

@RequestScoped
public class MyMessageConsumer {

	@Inject
	private JMSContext context;
	
	@Resource(mappedName = "jms/MyTestQueue")
	private Queue myTestQueue;
	
	public String receivedMessage() {
		return context.createConsumer(myTestQueue).receiveBody(String.class);
	}
}
