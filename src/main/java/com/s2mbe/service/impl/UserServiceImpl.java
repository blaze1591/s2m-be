package com.s2mbe.service.impl;

import com.s2mbe.error.UserAlreadyExistsException;
import com.s2mbe.error.UserNotFoundException;
import com.s2mbe.error.validation.EntityValidator;
import com.s2mbe.model.transfer.DashboardRow;
import com.s2mbe.model.transfer.HirshProjection;
import com.s2mbe.model.user.Credentials;
import com.s2mbe.model.user.User;
import com.s2mbe.repository.UserRepository;
import com.s2mbe.service.MailService;
import com.s2mbe.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserServiceImpl implements UserService {

    private static final String DEFAULT_PHOTO = "https://res.cloudinary.com/dp2ty4s0z/image/upload" +
            "/w_200,h_200,c_crop,g_face,r_max/w_200/placeholder_jjhreo.jpg";

    private UserRepository userRepository;
    private EntityValidator entityValidator;
    private MailService mailService;

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Autowired
    public void setEntityValidator(EntityValidator entityValidator) {
        this.entityValidator = entityValidator;
    }

    @Autowired
    public void setMailService(MailService mailService) {
        this.mailService = mailService;
    }

    @Bean
    private PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    public User save(User user) throws Exception {
        entityValidator.validate(user);
        Credentials credentials = user.getCredentials();
        if (!userRepository.exists(StringUtils.trimToEmpty(user.getId()))) {
            if (this.findByNameOrEmail(credentials.getUserName(), user.getEmail()) != null) {
                throw new UserAlreadyExistsException();
            }
            user.setRegistrationDate(new Date());
            credentials.setPassword(passwordEncoder().encode(credentials.getPassword()));
//            mailService.sendRegistrationToken(user);
            user.setPhoto(DEFAULT_PHOTO);
        } else {
            credentials.setPassword(userRepository.findOne(user.getId())
                    .getCredentials()
                    .getPassword());
            if (user.getPhoto() == null) {
                user.setPhoto(DEFAULT_PHOTO);
            }
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
    public User findByNameOrEmail(String userName, String email) {
        return userRepository.findByCredentialsUserNameOrEmail(userName, email);
    }

    @Override
    public List<DashboardRow> findTop10ScopusUsers() {
        return userRepository.findTop10ByOrderByScopusCitationSummDesc();
    }

    @Override
    public Map<String, Object> findInfoForScopusReport() {
        List<HirshProjection> hirshProjs = userRepository.findListOfHirshProjections();
        Map<Integer, Map<Integer, Map<String, Number>>> sumsForGraph = new HashMap<>();
        List<Map<String, Object>> forEachUserList = new ArrayList<>();
        for (HirshProjection hProj : hirshProjs) {
            Map<Integer, Map<Integer, Map<String, Number>>> sumsForUser = new HashMap<>();
            Map<String, Object> feuMap = new HashMap<>();
            feuMap.put("commonData", hProj);
            HirshProjection.sumDataHelper(hProj.getHirshCollection(), sumsForUser);
            feuMap.put("sums", sumsForUser);
            forEachUserList.add(feuMap);
            HirshProjection.sumDataHelper(hProj.getHirshCollection(), sumsForGraph);
        }
        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("forGraph", sumsForGraph);
        resultMap.put("forPDF", forEachUserList);
        return resultMap;
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

    /**
     * Activate user by given registrationToken
     *
     * @param registrationToken to look by
     * @throws IllegalArgumentException is user was not found by given registrationToken
     */
    @Override
    public User activateUser(String registrationToken) {
        User user = userRepository.findByRegistrationToken(registrationToken);
        if (user == null) {
            throw new IllegalArgumentException("Wrong registration token!");
        }
        user.setActive(true);
        return userRepository.save(user);
    }

    @Override
    public boolean changePassword(String id, String newPassword) {
        User user = userRepository.findOne(id);
        if (user == null) {
            return false;
        }
        user.getCredentials().setPassword(passwordEncoder().encode(newPassword));
        return userRepository.save(user) != null;
    }


}
