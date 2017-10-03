package com.s2mbe.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@SpringBootApplication(scanBasePackages = "com.s2mbe")
@EnableMongoRepositories(basePackages = "com.s2mbe.repository")
public class Application {

	@RequestMapping("/")
	@ResponseBody
	String home() {
        return "Hello World";
    }

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}