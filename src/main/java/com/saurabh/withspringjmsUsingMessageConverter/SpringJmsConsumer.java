package com.saurabh.withspringjmsUsingMessageConverter;

import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.TextMessage;

import org.springframework.jms.core.JmsTemplate;

public class SpringJmsConsumer {

	private JmsTemplate jmsTemplate;
	private Destination destination;
	
	public JmsTemplate getJmsTemplate() {
		return jmsTemplate;
	}
	public void setJmsTemplate(JmsTemplate jmsTemplate) {
		this.jmsTemplate = jmsTemplate;
	}
	public Destination getDestination() {
		return destination;
	}
	public void setDestination(Destination destination) {
		this.destination = destination;
	}
	
	public Person receiveMessage() throws JMSException {
        Person person = (Person) getJmsTemplate().receiveAndConvert(destination);
        return person;  
    }
	
}
