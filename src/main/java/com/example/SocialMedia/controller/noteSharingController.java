package com.example.SocialMedia.controller;

import com.example.SocialMedia.entity.NoteSharing;
import com.example.SocialMedia.service.NoteSharingService;
//import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class noteSharingController {
    @Autowired
    private NoteSharingService noteSharingService;

    @PostMapping("/create")
    private  String create(@RequestBody NoteSharing noteSharing){
        noteSharingService.create(noteSharing);
        return  "success";
    }
    @GetMapping("/byId")
    private  NoteSharing findById(@RequestParam long id){
        NoteSharing note = noteSharingService.fidById(id);
        return note;
    }
}
