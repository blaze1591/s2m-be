package com.s2mbe.error;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

@ControllerAdvice
public class ErrorHander {
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<Map<String,String>> handleIllegalArgumentException(IllegalArgumentException ex) {
        return new ResponseEntity<>(createErrorRecord(ex), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<Map<String,String>> handleObjectNotFoundException(NoSuchElementException ex) {
        return new ResponseEntity<>(createErrorRecord(ex), HttpStatus.NOT_FOUND);
    }

    private Map<String,String> createErrorRecord(Exception ex) {
        Map<String, String> errorRecord = new HashMap<>();
        errorRecord.put("error", ex.getMessage());
        return errorRecord;
    }
}
