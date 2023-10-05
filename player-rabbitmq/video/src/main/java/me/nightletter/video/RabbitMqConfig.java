package me.nightletter.video;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMqConfig {

	private static final String EXCHANGE_NAME = "sample.exchange";
	private static final String QUEUE_NAME = "sample.queue";
	private static final String ROUTING_KEY = "sample.routing.#";

	@Bean
	DirectExchange exchange() {
		return new DirectExchange(EXCHANGE_NAME, true, false);
	}

	@Bean
	Queue queue() {
		return new Queue(QUEUE_NAME);
	}

	@Bean
	Binding binding ( Queue queue, DirectExchange exchange) {
		return BindingBuilder.bind(queue).to(exchange).with(ROUTING_KEY);
	}

	@Bean
	RabbitTemplate rabbitTemplate( ConnectionFactory connectionFactory) {
		RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
		rabbitTemplate.setMessageConverter(new Jackson2JsonMessageConverter());
		return rabbitTemplate;
	}

}
