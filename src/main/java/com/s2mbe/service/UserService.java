package com.s2mbe.service;

import com.s2mbe.model.transfer.DashboardRow;
import com.s2mbe.model.user.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public interface UserService {
    User save(User user) throws Exception;

    void delete(String id);

    List<User> findAll();

    User findById(String id);

    User findByEmail(String email);

    User findByNameOrEmail(String userName, String email);

    List<DashboardRow> findTop10Users();

    Map<String, Object> findInfoForScopusReport();

    User findByName(String name);

    User activateUser(String registrationToken);

    boolean changePassword(String id, String newPassword);
}
