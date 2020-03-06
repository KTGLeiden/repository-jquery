package com.capgemini.koen.application;

import com.capgemini.koen.application.models.Message;
import com.capgemini.koen.application.repositories.HelloWorldRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class HelloWorldController {

    @Autowired
    private HelloWorldRepository helloWorldRepository;

    @GetMapping("/hello")
    public String index() {
        return "Hello, world!";
    }

    @GetMapping("/hasan")
    public String anotherIndex() {
        return "Hi, Hasan!";
    }

    @GetMapping()
    public List<Message> getAll() {
        return helloWorldRepository.findAll();
    }

    @PostMapping()
    public Message save(@RequestBody Message message) {
        return helloWorldRepository.save(message);
    }

}

