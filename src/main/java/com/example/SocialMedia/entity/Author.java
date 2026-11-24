package com.example.SocialMedia.entity;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private  String author;
    private  String authorEmail;
    private String authorPassword;

    @OneToMany(mappedBy = "author",cascade = CascadeType.ALL, orphanRemoval = true)
    List<NoteSharing> notes;
}
