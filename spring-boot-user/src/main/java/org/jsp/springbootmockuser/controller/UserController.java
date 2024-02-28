package org.jsp.springbootmockuser.controller;

import org.jsp.springbootmockuser.dto.ResponseStructure;
import org.jsp.springbootmockuser.dto.User;
import org.jsp.springbootmockuser.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
	@Autowired
	private UserService userService;
	@PostMapping("/users")
	public ResponseEntity<ResponseStructure<User>> saveUser(@RequestBody User user){
		return userService.saveUser(user);
		
	}
	@PutMapping("/users")
	public ResponseEntity<ResponseStructure<User>> updateUser(@RequestBody User user){
		return userService.updateUser(user);
		
	}
	@GetMapping("/users/{id}")
	public ResponseEntity<ResponseStructure<User>> findById(@PathVariable(name="id")int id){
		return userService.findById(id);
	}
	@PostMapping("/users/verify-by-phone")
	public ResponseEntity<ResponseStructure<User>> verifyUser(@RequestParam(name="phone") long phone,@RequestParam(name="password")String password){
		return userService.verifyUser(phone, password);
	}
	@PostMapping("/users/verify-by-email")
	public ResponseEntity<ResponseStructure<User>> verifyUser(@RequestParam(name="email") String email,@RequestParam(name="password")String password){
		return userService.verifyUser(email, password);
	}

}