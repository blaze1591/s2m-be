package com.s2mbe.controller;

import com.s2mbe.model.user.User;
import com.s2mbe.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping
    public ResponseEntity<List<User>> showAllUsers() {
        List<User> users = userService.findAll();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<User> saveUser(@RequestBody User user) throws Exception {
        user = userService.save(user);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity deleteUser(@PathVariable("id") String id) {
        userService.delete(id);
        return new ResponseEntity(HttpStatus.OK);
    }

    @PostMapping("/password/{id}")
    public ResponseEntity changePassword(@PathVariable String id, @RequestAttribute String newPassword) {
        if (userService.changePassword(id, newPassword)) {
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.badRequest().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> showUser(@PathVariable String id) {
        return ResponseEntity.ok(userService.findById(id));
    }
}
