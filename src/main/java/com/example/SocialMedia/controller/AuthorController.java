package com.example.SocialMedia.controller;

import com.example.SocialMedia.payload.request.AuthorRequestDto;
import com.example.SocialMedia.payload.request.NoteSharingRequest;
import com.example.SocialMedia.payload.request.NoteSharingResponse;
import com.example.SocialMedia.payload.response.AuthorResponse;
import com.example.SocialMedia.service.AuthorService;
import com.example.SocialMedia.service.NoteSharingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("Author")

public class AuthorController {


    @Autowired
    AuthorService authorService;

    @PostMapping("/create")
    private String create(@RequestBody AuthorRequestDto authorRequestDto) {
        authorService.create(authorRequestDto);
        return "success";
    }

    @GetMapping("/byId")
    private AuthorResponse findById(@RequestParam long id) {
        AuthorResponse authorResponse = authorService.findById(id);
        return authorResponse;
    }

    @GetMapping("/getAll")
    private List<AuthorResponse> findAll(){
        return authorService.getEverything();
    }

    @DeleteMapping("/delete")
    public  String delete(Long id){
        authorService.delete(id);
        return  "delete successfully";
    }
}
