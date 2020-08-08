package com.digi.trainers.hack.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.digi.trainers.hack.responses.ErrorMessage;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler({Exception.class})
	public ResponseEntity<ErrorMessage> handleException(Exception exception) {
		return new ResponseEntity<ErrorMessage>(new ErrorMessage("Error Occured", exception.getMessage()), HttpStatus.BAD_REQUEST);
	}
}
