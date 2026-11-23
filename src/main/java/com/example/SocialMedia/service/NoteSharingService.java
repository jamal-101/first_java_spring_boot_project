package com.example.SocialMedia.service;
import com.example.SocialMedia.entity.NoteSharing;
import com.example.SocialMedia.payload.request.NoteSharingRequest;
import com.example.SocialMedia.payload.request.NoteSharingResponse;
import com.example.SocialMedia.repository.NoteSharingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
        noteSharing.setTitle(noteSharingRequest.getTitle());
        noteSharing.setContact(noteSharingRequest.getContact());

        return noteSharing;

    }

    public NoteSharingResponse convertToResponse(NoteSharing noteSharing){
        NoteSharingResponse noteSharingResponse = new NoteSharingResponse();
        noteSharingResponse.setContact(noteSharing.getContact());
        noteSharingResponse.setTitle(noteSharing.getTitle());
        return  noteSharingResponse;

    }

    public NoteSharingResponse findById(Long id) {
        NoteSharing note = noteSharingRepository.findById(id).get();
        NoteSharingResponse noteSharingResponse = convertToResponse(note);
        return  noteSharingResponse;
    }

   public List<NoteSharingResponse> getEverything(){
        List<NoteSharing> noteSharing =   noteSharingRepository.findAll();
        List<NoteSharingResponse> noteSharingResponses = new ArrayList<>();
        for (NoteSharing note:noteSharing){
            NoteSharingResponse noteSharingResponse = convertToResponse(note);
            noteSharingResponses.add(noteSharingResponse);
        }

        return  noteSharingResponses;

   }

   public String delete(long id){
        noteSharingRepository.deleteById(id);
        return "note sharing delete successfully";
   }

}
