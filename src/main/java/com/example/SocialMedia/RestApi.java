package com.example.SocialMedia;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestApi {
    @GetMapping("/hi")
    String hello(){
        return  "Hello World";
    }
}
