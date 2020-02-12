package com.capgemini.koen.application;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class HelloWorldController {

    @GetMapping("/hello")
    public String index() {
        return "Hello, world!";
    }

    @GetMapping("/hasan")
    public String anotherIndex() {
        return "Hi, Hasan!";
    }
}

