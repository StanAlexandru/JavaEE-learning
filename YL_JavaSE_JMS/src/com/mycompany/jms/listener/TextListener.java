package com.mycompany.jms.listener;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

public class TextListener implements MessageListener{

	@Override
	public void onMessage(Message message) {
		
		if(message instanceof TextMessage) {
			TextMessage msg = (TextMessage) message;
			try {
				System.out.println("Reading message: " + msg.getText());
			} catch (JMSException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			System.out.println("Message is not text!");
		}
	}

}
