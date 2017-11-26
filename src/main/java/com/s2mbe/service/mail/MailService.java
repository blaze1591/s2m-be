package com.s2mbe.service.mail;

import com.s2mbe.model.user.User;

public interface MailService {
    void sendRegistrationToken(User user);
}
