package com.s2mbe.repository;

import com.s2mbe.model.user.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User, String> {
    User findByCredentialsUserName(String userName);

    User findByCredentialsUserNameOrEmail(String userName, String email);

    User findByEmail(String email);

    User findByRegistrationToken(String registrationToken);
}
