package com.youtube.java.puzzle.controller;

import com.youtube.java.puzzle.model.User;
import com.youtube.java.puzzle.service.UserClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/users-details")
public class UserController {
    @Autowired
    UserClient userClient;

    @GetMapping("/")
    public Flux<User> getAllUsers(){
        return userClient.getAll();
    }

    @GetMapping("/{id}")
    public Mono<User> getById(@PathVariable("id") Long id){
        return userClient.getById(id);
    }
}
