package com.saurabh.jmstestwithoutSpring;

import javax.jms.Connection;
import javax.jms.DeliveryMode;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnectionFactory;

public class HelloWorldProducer {

	public static void produceMessage() {
		
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
			MessageProducer messageProducer = session.createProducer(destination);
			//non persistant--no need to save in db
			messageProducer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);
			
			
			//Create a Message
			String text = "Hello World from " + Thread.currentThread().getName();
			TextMessage message = session.createTextMessage(text);
			
			//tell the provider to sent message
			messageProducer.send(message);
			
			session.close();
			connection.close();
			
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
