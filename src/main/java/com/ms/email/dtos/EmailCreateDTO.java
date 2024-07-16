package com.ms.email.dtos;

public record EmailCreateDTO(
        Long userID,
        String emailTo,
        String subject,
        String text) {
}
