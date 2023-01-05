package com.domo.security.resources;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldResource {

    @GetMapping("/hello-world")
    public String helloWorld() {
        return "Hello World 4";
    }

    @GetMapping("/")
    public String helloWorldOauth(Authentication authentication) {
        System.out.println(authentication);
        return "Hello World";
    }

}
