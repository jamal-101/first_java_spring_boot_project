package com.example.SocialMedia.repository;

import com.example.SocialMedia.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface AuthorRepository extends JpaRepository<Author,Long> {
}
