package br.com.jccf.spring.mvc.amqp.rabbitmq.producer;

import br.com.jccf.spring.mvc.amqp.rabbitmq.config.RabbitMqConfig;
import br.com.jccf.spring.mvc.amqp.rabbitmq.entity.LogMessage;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LogProducer {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    private final Logger log = LoggerFactory.getLogger(LogProducer.class);

    public void sendLogMessage(LogMessage message) {
        try {
            String json = new ObjectMapper().writeValueAsString(message);
            rabbitTemplate.convertAndSend(RabbitMqConfig.EXCHANGE_NAME, "", json);
        } catch (JsonProcessingException e) {
            log.error("Error on send message. Detail: {}", e.getMessage());
        }
    }
}
