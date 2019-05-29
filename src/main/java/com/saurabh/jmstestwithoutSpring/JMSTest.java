package com.saurabh.jmstestwithoutSpring;

public class JMSTest {

	public static void main(String[] args) {
		HelloWorldProducer.produceMessage();
		HelloWorldConsumer.consumeMessage();

	}

}
