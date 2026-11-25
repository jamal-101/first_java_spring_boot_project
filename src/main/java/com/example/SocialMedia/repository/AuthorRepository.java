package com.example.SocialMedia.repository;

import com.example.SocialMedia.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.Optional;

import java.util.List;

@Repository

public interface AuthorRepository extends JpaRepository<Author,Long> {

    Optional<Author> findByAuthorEmail(String authorEmail);

    @Query("SELECT a FROM Author a LEFT JOIN a.notes n")
    List<Author> findAllNotes();

    @Query("SELECT a FROM Author a LEFT JOIN a.notes n WHERE a.id= : id")
    Author findById(long id);
}
