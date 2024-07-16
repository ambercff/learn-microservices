package com.ms.user.services;

import com.ms.user.models.User;
import com.ms.user.producers.UserProducer;
import com.ms.user.repositories.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    final UserRepository repository;

    final UserProducer userProducer;

    public UserService(UserRepository repository, UserProducer userProducer) {
        this.repository = repository;
        this.userProducer = userProducer;
    }

    @Transactional
    public User save(User user){
        user = repository.save(user);
        userProducer.publishMessageEmail(user);
        return user;
    }
}
