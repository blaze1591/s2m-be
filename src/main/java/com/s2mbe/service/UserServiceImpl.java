package com.s2mbe.service;

import com.s2mbe.error.UserNotFoundException;
import com.s2mbe.error.validation.EntityValidator;
import com.s2mbe.model.Credentials;
import com.s2mbe.model.User;
import com.s2mbe.repository.UserRepository;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    private EntityValidator entityValidator;

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Autowired
    public void setEntityValidator(EntityValidator entityValidator) {
        this.entityValidator = entityValidator;
    }

    @Bean
    private PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    public User save(User user) throws Exception {
        entityValidator.validateBody(user);
        if (!userRepository.exists(StringUtils.trimToEmpty(user.getId()))) {
            user.setRegistrationDate(new Date());
            Credentials credentials = user.getCredentials();
            credentials.setPassword(passwordEncoder().encode(credentials.getPassword()));
            //TODO: activation logic
//        user.getCredentials().setActive(false);
        }

        return userRepository.save(user);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    /**
     * Returns user with given id
     *
     * @param id to look for
     * @return user with given id
     * @throws UserNotFoundException if user with given id does not exists
     */
    @Override
    public User findById(String id) {
        if (userRepository.exists(id)) {
            return userRepository.findOne(id);
        } else {
            throw new UserNotFoundException();
        }
    }

    @Override
    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public User findByName(String name) {
        return userRepository.findByCredentialsUserName(name);
    }

    /**
     * Deletes user by given id
     *
     * @param id to look for
     * @throws UserNotFoundException if user with given id does not exists
     */
    @Override
    public void delete(String id) {
        if (userRepository.exists(id)) {
            userRepository.delete(id);
        } else {
            throw new UserNotFoundException();
        }
    }
}