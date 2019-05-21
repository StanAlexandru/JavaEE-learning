package com.mycompany.jms.mymessage;

import javax.annotation.Resource;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.jms.JMSContext;
import javax.jms.Queue;

@RequestScoped
public class MyMessageProducer {

	@Inject
	private JMSContext context;
	
	@Resource(mappedName = "jms/MyTestQueue")
	private Queue myTestQueue;
	
	public void sendMessage(String payload) {
		context.createProducer().send(myTestQueue, payload);
	}
}
