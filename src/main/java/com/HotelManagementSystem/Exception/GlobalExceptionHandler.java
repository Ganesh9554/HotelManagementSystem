package com.HotelManagementSystem.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(RoomNotFoundException.class)
	  public ResponseEntity<String> handleRoomNotFoundException(RoomNotFoundException rnfe){
		  return new ResponseEntity<String>(rnfe.getMessage(),HttpStatus.BAD_REQUEST);
	  }
	@ExceptionHandler(CustomerNotFoundException.class)
	public ResponseEntity<String> handleCustomerNotFoundException(CustomerNotFoundException cnfe){
		  return new ResponseEntity<String>(cnfe.getMessage(),HttpStatus.BAD_REQUEST);
	  }
}
