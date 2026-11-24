package com.example.SocialMedia.controller;
import com.example.SocialMedia.entity.NoteSharing;
import com.example.SocialMedia.payload.request.NoteSharingRequest;
import com.example.SocialMedia.payload.request.NoteSharingResponse;
import com.example.SocialMedia.service.NoteSharingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("NoteSharing")
public class NoteSharingController {
    @Autowired
    private NoteSharingService noteSharingService;

    @PostMapping("/create")
    private String create(@RequestBody NoteSharingRequest noteSharingRequest) {
        noteSharingService.create(noteSharingRequest);
        return "success";
    }

    @GetMapping("/byId")
    private NoteSharingResponse findById(@RequestParam long id) {
        NoteSharingResponse noteSharingResponse = noteSharingService.findById(id);
        return noteSharingResponse;
    }

    @GetMapping("/getAll")
    private List<NoteSharingResponse> findAll(){
        return noteSharingService.getEverything();
    }

    @DeleteMapping("/delete")
    public  String delete(Long id){
        noteSharingService.delete(id);
        return  "delete successfully";
    }

}