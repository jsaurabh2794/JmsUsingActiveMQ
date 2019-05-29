package com.saurabh.withspringjmsUsingMessageConverter;

import javax.jms.JMSException;

import org.springframework.context.support.ClassPathXmlApplicationContext;



public class SpringJmsMessageConverterExample {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("JMSTestSpringConfigurationUsingMessageConverter.xml");
 
        try {
        	SpringJmsProducer springJmsProducer = (SpringJmsProducer) context.getBean("springJmsProducer");
            Person joe = new Person("Joe", 32);
            System.out.println("Sending person " + joe);
            springJmsProducer.sendMessage(joe);
            
            SpringJmsConsumer springJmsConsumer = (SpringJmsConsumer) context.getBean("springJmsConsumer");
            System.out.println("Consumer receives " + springJmsConsumer.receiveMessage());
        } catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
            context.close();
        }

	}

}
