package com.ms.user.dtos;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
public class EmailCreateDTO{
    private Long userID;
    private String emailTo;
    private String subject;
    private String text;
}
