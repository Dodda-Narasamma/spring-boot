package org.jsp.springbootmockuser.exception;

import org.jsp.springbootmockuser.dto.ResponseStructure;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
@ControllerAdvice
public class UserBootExceptionHandler extends ResponseEntityExceptionHandler{
	@ExceptionHandler(IdNotFoundException.class)
public ResponseEntity<ResponseStructure<String>> handlerINFE(IdNotFoundException e){
		ResponseStructure< String> structure=new ResponseStructure<>();
		structure.setData(e.getMessage());
		structure.setMesssage("user not found");
		structure.setStatusCode(HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<ResponseStructure<String>>(structure,HttpStatus.NOT_FOUND);
	} 
	@ExceptionHandler(InvalidCredentialsExceprion.class)
	public ResponseEntity<ResponseStructure<String>> handlerINCE(InvalidCredentialsExceprion e){
			ResponseStructure< String> structure=new ResponseStructure<>();
			structure.setData(e.getMessage());
			structure.setMesssage("user not found");
			structure.setStatusCode(HttpStatus.NOT_FOUND.value());
			return new ResponseEntity<ResponseStructure<String>>(structure,HttpStatus.NOT_FOUND);
		} 
}
