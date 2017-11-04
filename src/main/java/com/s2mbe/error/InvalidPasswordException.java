package com.s2mbe.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.UNAUTHORIZED, reason = "Password is Invalid")
public class InvalidPasswordException extends RuntimeException {
}
