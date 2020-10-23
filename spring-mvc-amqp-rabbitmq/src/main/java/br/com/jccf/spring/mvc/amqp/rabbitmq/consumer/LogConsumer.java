package br.com.jccf.spring.mvc.amqp.rabbitmq.consumer;

import br.com.jccf.spring.mvc.amqp.rabbitmq.config.RabbitMqConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class LogConsumer {

    private final Logger log = LoggerFactory.getLogger(LogConsumer.class);

    @RabbitListener(queues = RabbitMqConfig.QUEUE)
    public void consumer(Message message) {
        log.info("Log message received. Message: {}", message);
    }
}
