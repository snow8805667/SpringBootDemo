package com.fire.rabbitmq;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FanoutRabbitConfig {

	@Bean
	public Queue AMessage() {
		return new Queue("fanout.A");
	}

	@Bean
	public Queue BMessage() {
		return new Queue("fanout.B");
	}

	@Bean
	public Queue CMessage() {
		return new Queue("fanout.C");
	}

	//jiaohuanqi
	@Bean
	FanoutExchange fanoutExchange() {
		return new FanoutExchange("fanoutExchange");
	}
	//把A路由绑定到交换器上
	@Bean
	Binding bindingExchangeA(Queue AMessage, FanoutExchange fanoutExchange) {
		return BindingBuilder.bind(AMessage).to(fanoutExchange);
	}

	@Bean
	Binding bindingExchangeB(Queue BMessage, FanoutExchange fanoutExchange) {
		return BindingBuilder.bind(BMessage).to(fanoutExchange);
	}

	@Bean
	Binding bindingExchangeC(Queue CMessage, FanoutExchange fanoutExchange) {
		return BindingBuilder.bind(CMessage).to(fanoutExchange);
	}

}
