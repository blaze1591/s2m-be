package com.s2mbe.error.validation;

import com.google.common.collect.ImmutableMap;
import com.s2mbe.model.User;
import com.s2mbe.model.BasicEntity;
import com.s2mbe.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Optional;

@Component
public class EntityValidator {
    @Autowired
    UserRepository userRepository;
    private Map<Class,Validator> validatorMap = ImmutableMap.<Class, Validator> builder()
            .put(User.class, new UserValidator())
            .build();

    public void validateId(Class type, String id) throws Exception {
        Optional<Validator> validator = getValidator(type);
        if (validator.isPresent()) {
            validator.get().validateId(id);
        }
    }

    public void validateBody(Class type, BasicEntity entity) throws Exception {
        Optional<Validator> validator = getValidator(type);
        if (validator.isPresent()) {
            validator.get().validateBody(entity);
        }
    }

    private Optional<Validator> getValidator(Class type) {
        return Optional.ofNullable(validatorMap.get(type));
    }


    interface Validator<T extends BasicEntity> {
        void validateId(String id) throws Exception;
        void validateBody(T entity) throws Exception;
    }

    class UserValidator implements Validator<User> {
        @Override
        public void validateId(String id) throws Exception {
            User user = userRepository.findOne(id);
            if (user == null) {
                throw new NoSuchElementException("Can not resolve user by id : " + id);
            }
        }

        @Override
        public void validateBody(User user) throws Exception {
            if (user.getCredentials().getUserName() == null) {
                throw new IllegalArgumentException("userName must be specified");
            }
            if (user.getCredentials().getPassword() == null) {
                throw new IllegalArgumentException("password must be specified");
            }
            if (user.getCredentials().getRole() == null) {
                throw new IllegalArgumentException("User role must be specified");
            }
            if (user.getEmail() == null) {
                throw new IllegalArgumentException("email must be specified");
            }
            if (user.getFirstName() == null) {
                throw new IllegalArgumentException("firstName must be specified");
            }
            if (user.getLastName() == null) {
                throw new IllegalArgumentException("lastName must be specified");
            }
        }
    }
}
