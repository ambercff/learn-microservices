package com.ms.email.consumers;

import com.ms.email.dtos.EmailCreateDTO;
import com.ms.email.models.Email;
import com.ms.email.services.EmailService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.BeanUtils;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class EmailConsumer {

    final EmailService emailService;

    public EmailConsumer(EmailService emailService) {
        this.emailService = emailService;
    }

    @RabbitListener(queues = "${broker.queue.email.name}")
    public void listenEmailQueue(@Payload EmailCreateDTO data){
        Email email = new Email();
        BeanUtils.copyProperties(data, email);
        emailService.sendEmail(email);
    }
}
