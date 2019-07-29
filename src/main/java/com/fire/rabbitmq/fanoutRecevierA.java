package com.fire.rabbitmq;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues="fanout.A")
public class fanoutRecevierA {

	@RabbitHandler
	public void process(String message){
		System.out.println("fanout Recevier1:"+message);
	}
}
