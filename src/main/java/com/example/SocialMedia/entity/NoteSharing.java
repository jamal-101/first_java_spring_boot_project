package com.example.SocialMedia.entity;
import jakarta.persistence.*;
import lombok.Data;
import org.apache.catalina.User;

@Entity

@Data
public class NoteSharing {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  long id;
    private String title;
    private String contact;


    @ManyToOne
    @JoinColumn(name =  "author_id")
    private  Author author;


}
