package com.example.SocialMedia.payload.request;

import lombok.Data;

@Data
public class AuthorRequestDto {
    private String author;
    private String authorEmail;
    private String authorPassword;
}
