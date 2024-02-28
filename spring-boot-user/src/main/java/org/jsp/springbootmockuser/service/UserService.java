package org.jsp.springbootmockuser.service;

import java.util.Optional;

import org.jsp.springbootmockuser.dao.UserDao;
import org.jsp.springbootmockuser.dto.ResponseStructure;
import org.jsp.springbootmockuser.dto.User;
import org.jsp.springbootmockuser.exception.IdNotFoundException;
import org.jsp.springbootmockuser.exception.InvalidCredentialsExceprion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UserService {
	@Autowired
	private UserDao userDao;
	
	public ResponseEntity<ResponseStructure<User>> saveUser(User user){
		ResponseStructure<User>  structure=new ResponseStructure<>();
		structure.setData(userDao.saveUser(user));
		structure.setMesssage("user saved");
		structure.setStatusCode(HttpStatus.CREATED.value());
		return new ResponseEntity<ResponseStructure<User>>(structure,HttpStatus.CREATED);
		
	}
	public ResponseEntity<ResponseStructure<User>> updateUser(User user){
		ResponseStructure<User>  structure=new ResponseStructure<>();
		structure.setData(userDao.updateUser(user));
		structure.setMesssage("user saved");
		structure.setStatusCode(HttpStatus.ACCEPTED.value());
		return new ResponseEntity<ResponseStructure<User>>(structure,HttpStatus.ACCEPTED);
		
	}
	public ResponseEntity<ResponseStructure<User>> findById(int id){
		ResponseStructure<User> structure=new ResponseStructure<>();
		Optional<User> recUser=userDao.findById(id);
		if(recUser.isPresent()) {
			structure.setData(recUser.get());
			structure.setMesssage("user found");
			structure.setStatusCode(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<User>>(structure,HttpStatus.ACCEPTED);
			
	}
		throw new IdNotFoundException();
		
	}
	public ResponseEntity<ResponseStructure<User>> verifyUser(long phone,String password){
		ResponseStructure<User> structure=new ResponseStructure<>();
		Optional<User> recUser=userDao.verifyByphone(phone, password);
		if(recUser.isPresent()) {
			structure.setData(recUser.get());
			structure.setMesssage("user found");
			structure.setStatusCode(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<User>>(structure,HttpStatus.OK);
			
	}
		throw new InvalidCredentialsExceprion();
		
	}
	public ResponseEntity<ResponseStructure<User>> verifyUser(String email,String password){
		ResponseStructure<User> structure=new ResponseStructure<>();
		Optional<User> recUser=userDao.verifyByemail(email, password);
		if(recUser.isPresent()) {
			structure.setData(recUser.get());
			structure.setMesssage("user found");
			structure.setStatusCode(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<User>>(structure,HttpStatus.OK);
			
	}
		throw new InvalidCredentialsExceprion();
		
	}
}
