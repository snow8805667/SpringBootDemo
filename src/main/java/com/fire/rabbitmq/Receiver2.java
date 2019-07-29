package com.fire.rabbitmq;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import com.fire.domain.User;

@Component
@RabbitListener(queues="topic.messages")
public class Receiver2 {

	@RabbitHandler
	public void process(String message){
		System.out.println("Topic Recevier2:"+message);
	}
	
	
	
	
	
}
