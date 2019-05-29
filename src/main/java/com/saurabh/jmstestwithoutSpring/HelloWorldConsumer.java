package com.saurabh.jmstestwithoutSpring;

import javax.jms.Connection;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnectionFactory;

public class HelloWorldConsumer {

	public static void consumeMessage() {
		
		//Creates Connection Factory
		ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://saurabh:61616");

		try {
			//Creates Connection
			Connection connection= connectionFactory.createConnection();
			connection.start();
			
			//Creates Session
			Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
			
			//Create the desination Topic/Queue
			Destination destination = session.createQueue("HELLOWORLD.TESTQ");
			
			//create the Message producer from the Session to the topic/queue
			MessageConsumer messageConsumer = session.createConsumer(destination);
			
			//wait for message
			Message text = messageConsumer.receive(1000);
			
			if(text instanceof TextMessage) {
				TextMessage textMessage = (TextMessage)text;
				String textMessageRecieved = textMessage.getText();
				System.out.println("Received: " + textMessageRecieved);
			}else {
				System.out.println("Received:" + text);
			}
			
			session.close();
			connection.close();
			
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
