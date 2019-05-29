package com.saurabh.withspringjms;

import javax.jms.JMSException;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringJmsTemplateExample {

	public static void main(String[] args) {
		//load the xml file to create beans
		ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("JMSTestSpringConfiguration.xml");

		try {
		// Create Jms producer
		SpringJmsProducer jmsProducer = (SpringJmsProducer)applicationContext.getBean("springJmsProducer");
		jmsProducer.sendMessage("Hello World");
		
		//Create Jms reciever
        SpringJmsConsumer consumer = (SpringJmsConsumer)applicationContext.getBean("springJmsConsumer");
        System.out.println("Consumer Receive: "+ consumer.receiveMessage());
		
		} catch (JMSException e) {
			e.printStackTrace();
		}finally {
			applicationContext.close();
		}
		
	
	}

}
