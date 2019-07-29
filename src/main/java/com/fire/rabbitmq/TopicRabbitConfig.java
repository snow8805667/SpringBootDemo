package com.fire.rabbitmq;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TopicRabbitConfig {
	final static String message = "topic.message";
	final static String messages = "topic.messages";
//隊列
	@Bean
	public Queue queueMessage() {
		return new Queue(TopicRabbitConfig.message);
	}
//隊列
	@Bean
	public Queue queueMessages() {
		return new Queue(TopicRabbitConfig.messages);
	}
//交换器
	@Bean
	TopicExchange exchange() {
		return new TopicExchange("topicExchage");
	}
//把隊列绑定到交换器
	@Bean
	Binding bindingExchangeMessage(Queue queueMessage, TopicExchange exchange) {
		return BindingBuilder.bind(queueMessage).to(exchange).with("topic.message");
	}
	//把隊列绑定到交换器
	@Bean
	Binding bindingExchangeMessages(Queue queueMessages, TopicExchange exchange) {
		return BindingBuilder.bind(queueMessages).to(exchange).with("topic.#");
	}

	@Bean
	public RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory) {
		RabbitTemplate template = new RabbitTemplate(connectionFactory);
		template.setMessageConverter(new Jackson2JsonMessageConverter());
		return template;
	}

	@Bean
	public SimpleRabbitListenerContainerFactory rabbitListenerContainerFactory(ConnectionFactory connectionFactory) {
		SimpleRabbitListenerContainerFactory factory = new SimpleRabbitListenerContainerFactory();
		factory.setConnectionFactory(connectionFactory);
		factory.setMessageConverter(new Jackson2JsonMessageConverter());
		return factory;
	}

}
