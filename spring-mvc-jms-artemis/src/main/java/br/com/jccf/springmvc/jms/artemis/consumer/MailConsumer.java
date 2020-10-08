package br.com.jccf.springmvc.jms.artemis.consumer;

import br.com.jccf.springmvc.jms.artemis.entity.Mail;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class MailConsumer {

    private static final Logger LOG = LoggerFactory.getLogger(MailConsumer.class);

    @JmsListener(destination = "queue.mail")
    public void retrieveMailTo(Mail mail) {
        LOG.info("TO: The content from mail is {}", mail.getContent());
    }

    @JmsListener(destination = "topic.mail", containerFactory = "jmsFactoryTopic")
    public void retrieveMailAllOne(Mail mail) {
        LOG.info("ALL 1: The content from mail is {}", mail.getContent());
    }

    @JmsListener(destination = "topic.mail", containerFactory = "jmsFactoryTopic")
    public void retrieveMailAllTwo(Mail mail) {
        LOG.info("ALL 2: The content from mail is {}", mail.getContent());
    }
}
