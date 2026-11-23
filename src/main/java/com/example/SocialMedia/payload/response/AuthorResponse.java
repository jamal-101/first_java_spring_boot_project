package com.example.SocialMedia.payload.response;


import com.example.SocialMedia.payload.request.NoteSharingResponse;
import lombok.Data;

import java.util.List;

@Data
public class AuthorResponse {
    private String author;
    private  String authorEmail;
    List<NoteSharingResponse> notes;
}
