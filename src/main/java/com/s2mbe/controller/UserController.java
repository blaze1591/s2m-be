package com.s2mbe.controller;

import com.s2mbe.model.User;
import com.s2mbe.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(maxAge = 3600)
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserServiceImpl userServiceImpl;

    @GetMapping
    public ResponseEntity<List<User>> showAllUsers() {
        List<User> users = userServiceImpl.findAll();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity deleteUser(@PathVariable("id") String id) {
        userServiceImpl.delete(id);
        return new ResponseEntity(HttpStatus.OK);
    }
}
