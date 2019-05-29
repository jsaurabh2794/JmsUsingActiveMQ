package com.saurabh.withspringjmsUsingMessageConverter;

import javax.jms.JMSException;
import javax.jms.MapMessage;
import javax.jms.Message;
import javax.jms.Session;

import org.springframework.jms.support.converter.MessageConverter;

public class PersonMessageConverter implements MessageConverter{

	//being called when producer produce any message
	@Override
	public Message toMessage(Object object, Session session) {
		 Person person = (Person) object;
	     MapMessage message=null;
	        try {
	        	 message = session.createMapMessage();
				 message.setString("name", person.getName());
				 message.setInt("age", person.getAge());
			} catch (JMSException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	       
	        return message;
	}

	//being called when Consumer consume any message
	@Override
	public Object fromMessage(Message message) {
	
		MapMessage mapMessage = (MapMessage) message;
	    Person person = null;
		try {
			person = new Person(mapMessage.getString("name"), mapMessage.getInt("age"));
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	        
		
		return person;
	}
		
}

