package com.fire.rabbitmq;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues="fanout.B")
public class fanoutRecevierB {
	
	@RabbitHandler
	public void process(String message){
		System.out.println("fanout RecevierB:"+message);
	}
}
