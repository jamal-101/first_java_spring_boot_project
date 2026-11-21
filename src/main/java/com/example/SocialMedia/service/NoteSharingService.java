//package com.example.SocialMedia.service;
//
//import com.example.SocialMedia.entity.NoteSharing;
//import com.example.SocialMedia.repository.NoteSharingRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//@Service
//
//public class NoteSharingService {
//    @Autowired
//    private NoteSharingRepository NoteSharingRepository;
//    public String create(NoteSharing noteSharing){
//        NoteSharingRepository.save(noteSharing);
//        return "note sharing save successfully";
//    }
//    public NoteSharing fidById(Long id){
//       NoteSharing note = NoteSharingRepository.findById(id).get();
//       return  note;
//    }
//}

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

    // সেভ করার পর তৈরি হওয়া ID সহ পুরো অবজেক্ট রিটার্ন করবে
    public NoteSharing create(NoteSharing noteSharing) {
        return noteSharingRepository.save(noteSharing);
    }

    // ID না পেলে ক্র্যাশ না করে null রিটার্ন করবে
    public NoteSharing findById(Long id) {
        return noteSharingRepository.findById(id).orElse(null);
    }

    // ডেটাবেসের সব ডেটা একসাথে দেখার জন্য
    public List<NoteSharing> getAll() {
        return noteSharingRepository.findAll();
    }
}
