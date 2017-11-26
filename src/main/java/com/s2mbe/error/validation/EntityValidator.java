package com.s2mbe.error.validation;

import com.google.common.collect.ImmutableMap;
import com.s2mbe.model.BasicEntity;
import com.s2mbe.model.user.User;
import com.s2mbe.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.Optional;

@Component
public class EntityValidator {
    @Autowired
    UserRepository userRepository;

    private Map<Class,Validator> validatorMap = ImmutableMap.<Class, Validator> builder()
            .put(User.class, new UserValidator())
            .build();

    public void validate(BasicEntity entity) throws Exception {
        Optional<Validator> validator = getValidator(entity.getClass());
        if (validator.isPresent()) {
            validator.get().validate(entity);
        }
    }

    private Optional<Validator> getValidator(Class type) {
        return Optional.ofNullable(validatorMap.get(type));
    }


    interface Validator<T extends BasicEntity> {
        void validate(T entity) throws Exception;
    }

    class UserValidator implements Validator<User> {
        @Override
        public void validate(User user) throws Exception {
            if (user.getCredentials() == null) {
                throw new IllegalArgumentException("Credentials must be specified with userName, password and role");
            }
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
                throw new IllegalArgumentException("Email must be specified");
            }
            if (user.getFirstName() == null) {
                throw new IllegalArgumentException("FirstName must be specified");
            }
            if (user.getLastName() == null) {
                throw new IllegalArgumentException("LastName must be specified");
            }
        }
    }
}
