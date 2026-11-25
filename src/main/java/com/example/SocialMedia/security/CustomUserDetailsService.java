package com.example.SocialMedia.security;

import com.example.SocialMedia.entity.Author;
import com.example.SocialMedia.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private AuthorRepository authorRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Author author = authorRepository.findByAuthorEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("User not found: " + email));
        return new CustomUserDetails(author);
    }
}