package com.s2mbe.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Користувач не знайдений")
public class UserNotFoundException extends RuntimeException {
}
