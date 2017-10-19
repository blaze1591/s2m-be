package com.s2mbe.service;

import com.s2mbe.model.User;
import com.s2mbe.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public boolean persistUser(User user) {
        user = userRepository.save(user);
        return user != null;
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }
}
