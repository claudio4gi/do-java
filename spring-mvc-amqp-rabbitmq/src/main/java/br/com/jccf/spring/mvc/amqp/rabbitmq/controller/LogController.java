package br.com.jccf.spring.mvc.amqp.rabbitmq.controller;

import br.com.jccf.spring.mvc.amqp.rabbitmq.entity.LogMessage;
import br.com.jccf.spring.mvc.amqp.rabbitmq.producer.LogProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/log")
public class LogController {

    @Autowired
    private LogProducer producer;

    @GetMapping
    public String log(@RequestParam String message) {
        producer.sendLogMessage(new LogMessage(message));
        return String.format("Log %s sent successful", message);
    }
}
