package com.s2mbe.service;

import com.s2mbe.error.validation.EntityValidator;
import com.s2mbe.model.User;
import com.s2mbe.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    EntityValidator entityValidator;

    public User persistUser(User user) throws Exception {
        entityValidator.validateBody(user);
        user.setRegistrationDate(new Date());
        user.setDeleted(false);
        //TODO: activation logic
//        user.getCredentials().setActive(false);
        return userRepository.save(user);
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User updateUser(String id, User user) throws Exception {
        entityValidator.validateId(User.class, id);
        entityValidator.validateBody(user);
        user.setId(id);
        return userRepository.save(user);
    }

    public User deleteUser(String id) throws Exception {
        entityValidator.validateId(User.class, id);
        User user = userRepository.findOne(id);
        user.setDeleted(true);
        return userRepository.save(user);
    }
}
