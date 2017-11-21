package com.s2mbe.service.mail;

import com.s2mbe.model.User;

public interface MailService {
    void sendRegistrationToken(User user);
}
