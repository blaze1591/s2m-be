package com.s2mbe.service.mail;

import com.s2mbe.controller.AuthController;
import com.s2mbe.model.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.UUID;

@Service
public class MailServiceImpl implements MailService {
    @Autowired
    public JavaMailSender emailSender;

    @Override
    public void sendRegistrationToken(User user) {
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        String message = formMessage(user);
        mailMessage.setTo(user.getEmail());
        mailMessage.setSubject("Confirm Registration");
        mailMessage.setText(message);
        emailSender.send(mailMessage);
    }

    private String formMessage(User user) {
        String serverUrl = null;
        try {
            serverUrl = getServerRootUrl();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        String registrationToken = UUID.randomUUID().toString().replace("-", "");

        user.setRegistrationToken(registrationToken);
        return "Hi, " + user.getFirstName() +
                "\nPlease click on the link below to proceed registration:\n" +
                serverUrl + AuthController.ACTIVATE_URL + registrationToken;
    }

    private String getServerRootUrl() throws MalformedURLException {
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        if (null != requestAttributes && requestAttributes instanceof ServletRequestAttributes) {
            HttpServletRequest request = ((ServletRequestAttributes) requestAttributes).getRequest();

            URL requestURL = new URL(request.getRequestURL().toString());
            String port = requestURL.getPort() == -1 ? "" : ":" + requestURL.getPort();
            return requestURL.getProtocol() + "://" + requestURL.getHost() + port;
        }
        return "";
    }
}
