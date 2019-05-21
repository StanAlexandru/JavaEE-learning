package com.mycompany.jms.mymessage;

import javax.annotation.Resource;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.jms.JMSContext;
import javax.jms.Topic;

@RequestScoped
public class MyTopicMessageProducer {

	@Inject
	private JMSContext context;
	
	@Resource(mappedName = "jms/MyTestTopic")
	private Topic myTestTopic;
	
	public void sendMessage(String payload) {
		context.createProducer().send(myTestTopic, payload);
		
		//Used to send Objects
		//the payload property can be used by "messageSelector" ActivationConfigProperty
		//to filter the responding MDBs
		/*try {
			Message m = context.createMapMessage();
			m.setObjectProperty("payload", payload);
			context.createProducer().send(myTestTopic, m);
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
	}
}
