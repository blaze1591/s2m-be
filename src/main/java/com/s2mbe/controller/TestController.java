package com.s2mbe.controller;

import com.s2mbe.model.TestEntity;
import com.s2mbe.repository.TestRepository;
import com.s2mbe.service.mail.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/test")
public class TestController {
    @Autowired
    TestRepository testRepository;
    @Autowired
    MailService mailService;

    @RequestMapping
    public ResponseEntity<List<TestEntity>> goTest() {
        List<TestEntity> testEntities = testRepository.findAll();
        return new ResponseEntity<>(testEntities, HttpStatus.OK);
    }
}
