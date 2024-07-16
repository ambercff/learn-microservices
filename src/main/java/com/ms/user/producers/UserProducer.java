package com.ms.user.producers;

import com.ms.user.dtos.EmailCreateDTO;
import com.ms.user.models.User;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class UserProducer {

    final RabbitTemplate rabbitTemplate;

    public UserProducer(RabbitTemplate rabbitTemplate){
        this.rabbitTemplate = rabbitTemplate;
    }

    @Value(value="${broker.queue.email.name}")
    private String routingKey;

    public void publishMessageEmail(User user){
        EmailCreateDTO emailDTO = new EmailCreateDTO();
        emailDTO.setUserID(user.getId());
        emailDTO.setEmailTo(user.getEmail());
        emailDTO.setSubject("Cadastro realizado com sucesso!");
        emailDTO.setText(user.getName() + ", seja bem vindo(a)!");

        rabbitTemplate.convertAndSend("", routingKey, emailDTO);
    }
}
