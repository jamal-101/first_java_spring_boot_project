package com.example.SocialMedia.service;
import com.example.SocialMedia.entity.NoteSharing;
import com.example.SocialMedia.payload.request.NoteSharingRequest;
import com.example.SocialMedia.payload.request.NoteSharingResponse;
import com.example.SocialMedia.repository.NoteSharingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class NoteSharingService {

    @Autowired
    private NoteSharingRepository noteSharingRepository;

    public NoteSharing create(NoteSharingRequest noteSharingRequest) {
        NoteSharing noteSharing = convertToRequest(noteSharingRequest);
        return noteSharingRepository.save(noteSharing);
    }

    public  NoteSharing convertToRequest(NoteSharingRequest noteSharingRequest){
        NoteSharing noteSharing = new NoteSharing();
        noteSharing.setAuthor(noteSharingRequest.getAuthor());
        noteSharing.setTitle(noteSharingRequest.getTitle());
        noteSharing.setContact(noteSharingRequest.getContact());
        noteSharing.setAuthorEmail(noteSharingRequest.getAuthorEmail());
        noteSharing.setAuthorPassword(noteSharingRequest.getAuthorPassword());

        return noteSharing;

    }

    public NoteSharingResponse convertToResponse(NoteSharing noteSharing){
        NoteSharingResponse noteSharingResponse = new NoteSharingResponse();
        noteSharingResponse.setAuthor(noteSharing.getAuthor());
        noteSharingResponse.setAuthorEmail(noteSharing.getAuthorEmail());
        noteSharingResponse.setContact(noteSharing.getContact());
        noteSharingResponse.setTitle(noteSharing.getTitle());
        return  noteSharingResponse;

    }

    public NoteSharingResponse findById(Long id) {
        NoteSharing note = noteSharingRepository.findById(id).get();
        NoteSharingResponse noteSharingResponse = convertToResponse(note);
        return  noteSharingResponse;
    }

   public List<NoteSharing> getEverything(){
        return  noteSharingRepository.findAll();
   }

   public String delete(long id){
        noteSharingRepository.deleteById(id);
        return "note sharing delete successfully";
   }

}
