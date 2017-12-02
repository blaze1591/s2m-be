package com.s2mbe.service;

import com.s2mbe.model.user.User;

public interface MailService {
    void sendRegistrationToken(User user);
}
