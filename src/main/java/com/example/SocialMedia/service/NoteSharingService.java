package com.example.SocialMedia.service;

import com.example.SocialMedia.entity.NoteSharing;
import com.example.SocialMedia.repository.NoteSharingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class NoteSharingService {
    @Autowired
    private NoteSharingRepository NoteSharingRepository;
    public String create(NoteSharing noteSharing){
        NoteSharingRepository.save(noteSharing);
        return "note sharing save successfully";
    }
    public NoteSharing fidById(Long id){
       NoteSharing note = NoteSharingRepository.findById(id).get();
       return  note;
    }
}
