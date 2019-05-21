package com.mycompany.jms.main;

import com.mycompany.jms.client.SimpleConsumerClient;

public class Main {

	public static void main(String[] args) {

		SimpleConsumerClient client = new SimpleConsumerClient();
		client.receiveMessage();

	}

}
