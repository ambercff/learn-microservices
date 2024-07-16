package com.ms.email.models;

import com.ms.email.dtos.EmailCreateDTO;
import com.ms.email.models.enums.StatusEmail;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name="email")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Email {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="email_from")
    private String emailFrom;

    @Column(name="email_to")
    private String emailTo;

    private String subject;
    private String text;

    @Column(name="send_date_email")
    private LocalDateTime sendDateEmail;

    @Enumerated(EnumType.STRING)
    @Column(name="status_email")
    private StatusEmail statusEmail;

}
