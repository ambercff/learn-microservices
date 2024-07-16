package com.ms.user.models;

import com.ms.user.dtos.UserCreateDTO;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="user")
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;


    public User(UserCreateDTO data) {
        this.email = data.email();
        this.name = data.name();
    }
}
