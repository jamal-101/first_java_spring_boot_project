package com.example.SocialMedia.payload.request;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class NoteSharingRequest {
    private String title;
    private String contact;
    private  String author;
    private  String authorEmail;
    private String authorPassword;
}
