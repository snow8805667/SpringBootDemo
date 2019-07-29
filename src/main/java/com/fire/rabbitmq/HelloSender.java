package com.fire.rabbitmq;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class HelloSender {
	
	@Autowired
	private AmqpTemplate rabbitmqTemplate;
	
	public void send1(){
		String context="hi,i am message 1";
		System.out.println("Sender:"+context);
		this.rabbitmqTemplate.convertAndSend("topicExchage","topic.message",context);
	}
	public void send2(){
		String context="hi,i am message 2";
		System.out.println("Sender:"+context);
		this.rabbitmqTemplate.convertAndSend("topicExchage","topic.messages",context);
	}
	
	public void send3(){
		
		String context="hi,fanout msg";
		System.out.println("Sender:"+context);
		this.rabbitmqTemplate.convertAndSend("fanoutExchange","",context);
		
		
	}
	
	
	
}
