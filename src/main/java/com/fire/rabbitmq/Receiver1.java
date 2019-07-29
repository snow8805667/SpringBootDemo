package com.fire.rabbitmq;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues="topic.message")
public class Receiver1 {

	@RabbitHandler
	@RabbitListener(queues = "topic.message", containerFactory="rabbitListenerContainerFactory")
	public void process(String message){
		System.out.println("Topic Recevier1:"+message);
	}
	
	
	
	
	
}
