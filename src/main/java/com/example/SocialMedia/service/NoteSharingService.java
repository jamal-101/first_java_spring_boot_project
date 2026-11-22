package com.example.SocialMedia.service;
import com.example.SocialMedia.entity.NoteSharing;
import com.example.SocialMedia.repository.NoteSharingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class NoteSharingService {

    @Autowired
    private NoteSharingRepository noteSharingRepository;

    public NoteSharing create(NoteSharing noteSharing) {
        return noteSharingRepository.save(noteSharing);
    }
    public NoteSharing findById(Long id) {
        return noteSharingRepository.findById(id).orElse(null);
    }

   public List<NoteSharing> getEverything(){
        return  noteSharingRepository.findAll();
   }

   public String delete(long id){
        noteSharingRepository.deleteById(id);
        return "note sharing delete successfully";
   }

}
