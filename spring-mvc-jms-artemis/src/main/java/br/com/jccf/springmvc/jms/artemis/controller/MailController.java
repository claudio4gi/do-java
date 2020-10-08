package br.com.jccf.springmvc.jms.artemis.controller;

import br.com.jccf.springmvc.jms.artemis.producer.MailProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/mail")
public class MailController {

    private final MailProducer mailProducer;

    @Autowired
    public MailController(MailProducer mailProducer) {
        this.mailProducer = mailProducer;
    }

    @GetMapping
    public String health() {
        return "Mail is working";
    }

    @PostMapping("/send_to")
    public void sendMailTo(@RequestParam String message) {
        mailProducer.sendMailTo(message);
    }

    @PostMapping("/send_all")
    public void sendMailAll(@RequestParam String message) {
        mailProducer.sendMailAll(message);
    }
}
