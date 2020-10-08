package br.com.jccf.springmvc.jms.artemis.producer;

import br.com.jccf.springmvc.jms.artemis.entity.Mail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Component
public class MailProducer {

    private final JmsTemplate jmsTemplate;
    @Qualifier("jmsTemplateTopic")
    private final JmsTemplate jmsTemplateTopic;

    @Autowired
    public MailProducer(JmsTemplate jmsTemplate, JmsTemplate jmsTemplateTopic) {
        this.jmsTemplate = jmsTemplate;
        this.jmsTemplateTopic = jmsTemplateTopic;
    }

    public void sendMailTo(String message) {
        jmsTemplate.convertAndSend("queue.mail", new Mail(message));
    }

    public void sendMailAll(String message) {
        jmsTemplateTopic.convertAndSend("topic.mail", new Mail(message));
    }
}
