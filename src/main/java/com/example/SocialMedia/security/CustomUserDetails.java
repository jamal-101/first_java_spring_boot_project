package com.example.SocialMedia.security;

import com.example.SocialMedia.entity.Author;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

public class CustomUserDetails implements UserDetails {

    private final Author author;

    public CustomUserDetails(Author author) {
        this.author = author;
    }

    public Long getId() {
        return author.getId();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("ROLE_" + author.getRole()));
    }

    @Override
    public String getPassword() {
        return author.getAuthorPassword();
    }

    @Override
    public String getUsername() {
        return author.getAuthorEmail();
    }
}