package com.s2mbe.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT, reason = "Логін чи поштова скринька вже використовуються")
public class UserAlreadyExistsException extends RuntimeException {
}
