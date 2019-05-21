package com.mycompany.jms.mdb;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

@MessageDriven(activationConfig = {
		@ActivationConfigProperty(propertyName = "destinationLookup", propertyValue = "jms/MyTestTopic"),
		@ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Topic")
})
public class MyTopicMDB2 implements MessageListener{

	@Override
	public void onMessage(Message message) {
		TextMessage msg = null;
		
		if(message instanceof TextMessage) {
			msg = (TextMessage) message;
			try {
				//http://localhost:4848/management/domain/view-log
				System.out.println("MyTopicMDB2 reading message: " + msg.getText());
			} catch (JMSException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
