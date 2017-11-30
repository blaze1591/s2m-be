package com.s2mbe.service;

import com.s2mbe.model.user.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
  User save(User user) throws Exception;

  void delete(String id);

  List<User> findAll();

  User findById(String id);

  User findByEmail(String email);

  User findByName(String name);

  User activateUser(String registrationToken);

  boolean changePassword(String id, String newPassword);
}
