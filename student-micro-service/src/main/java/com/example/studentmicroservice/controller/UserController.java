package com.example.studentmicroservice.controller;

import com.example.studentmicroservice.bean.User;
import com.example.studentmicroservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/getUsersInfo")
    public List<User> getUsersInfo() {
        Stream<User> stream = StreamSupport.stream(userRepository.findAll().spliterator(), false);
        return stream.collect(Collectors.toList());
    }

}
