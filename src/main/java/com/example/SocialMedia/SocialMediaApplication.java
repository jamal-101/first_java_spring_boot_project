package com.example.SocialMedia;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class SocialMediaApplication {

	public static void main(String[] args) {
		SpringApplication.run(SocialMediaApplication.class, args);
	}


	@PostMapping("/old")
	public String codi(@RequestParam int age) {
		// বড় কন্ডিশনগুলো সবসময় উপরে রাখতে হবে
		if (age > 100) {
			return "You are a living legend";
		} else if (age > 18) {
			return "You are older than 18 years old";
		} else if (age < 18) {
			return "You are younger than 18 years old";
		} else {
			return "You are exactly 18 years old";
		}
	}

}
