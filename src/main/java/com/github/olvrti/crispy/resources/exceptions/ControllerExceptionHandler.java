package com.github.olvrti.crispy.resources.exceptions;

import javax.servlet.http.HttpServletRequest;

import com.github.olvrti.crispy.services.exceptions.ObjectNotFoundException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ControllerExceptionHandler {

  @ExceptionHandler(ObjectNotFoundException.class)
  public ResponseEntity<String> objectNotFound(final ObjectNotFoundException exception,
      final HttpServletRequest request) {
    final StandardError error = new StandardError(HttpStatus.NOT_FOUND.value(), "Object not found",
        exception.getMessage(), System.currentTimeMillis(), request.getRequestURI());

    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error.getMessage());
  }
}
