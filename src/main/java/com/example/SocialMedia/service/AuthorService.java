package com.example.SocialMedia.service;

import com.example.SocialMedia.entity.Author;
import com.example.SocialMedia.entity.NoteSharing;
import com.example.SocialMedia.payload.request.AuthorRequestDto;
import com.example.SocialMedia.payload.request.NoteSharingResponse;
import com.example.SocialMedia.payload.response.AuthorResponse;
import com.example.SocialMedia.repository.AuthorRepository;
import com.example.SocialMedia.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service

public class AuthorService {
    @Autowired
    private AuthorRepository authorRepository;

    public String create(AuthorRequestDto authorRequestDto) {
        Author author = convertToRequest(authorRequestDto);
        authorRepository.save(author);
        return  "author save successfully";
    }

    public Author convertToRequest(AuthorRequestDto authorRequestDto){
        Author author = new Author();
        author.setAuthor(authorRequestDto.getAuthor());
        author.setAuthorEmail(authorRequestDto.getAuthorEmail());
        author.setAuthorPassword(authorRequestDto.getAuthorPassword());

        return author;

    }

    public AuthorResponse convertToResponse(Author author){
        AuthorResponse authorResponse = new AuthorResponse();
        authorResponse.setAuthor(author.getAuthor());
        authorResponse.setAuthorEmail(author.getAuthorEmail());

        List<NoteSharingResponse> nr = new ArrayList<>();
        for (NoteSharing note : author.getNotes()){
            NoteSharingResponse noteSharing = new NoteSharingResponse();
            noteSharing.setContact(note.getContact());
            noteSharing.setTitle(note.getTitle());
            noteSharing.setId(note.getId());
            nr.add(noteSharing);
        }
        authorResponse.setNotes(nr);
        return  authorResponse;

    }

    public AuthorResponse findById(Long id) {
        Author author = authorRepository.findById(id).get();
        AuthorResponse authorResponse = convertToResponse(author);
        return  authorResponse;
    }

    public List<AuthorResponse> getEverything(){
        List<Author> authors =   authorRepository.findAll();
        List<AuthorResponse> authorResponses = new ArrayList<>();
        for (Author author:authors){
            AuthorResponse authorResponse = convertToResponse(author);
            authorResponses.add(authorResponse);
        }

        return  authorResponses;

    }

    public String delete(Long id){
        authorRepository.deleteById(id);
        return "author delete successfully";
    }
}
