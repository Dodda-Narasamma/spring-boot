package org.jsp.springbootmockuser.dao;

import java.util.Optional;

import org.jsp.springbootmockuser.dto.User;
import org.jsp.springbootmockuser.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDao {
	@Autowired
	private UserRepository repository;
	
	public User saveUser(User user) {
		return   repository.save(user);
		
	}
	public User updateUser(User user) {
		return   repository.save(user);
		
	}
	public Optional<User> findById(int id) {
		return repository.findById(id);
		
	}
	public Optional<User> verifyByphone(long phone,String password) {
		return repository.verifyUser(phone,password);
	}

	public Optional<User> verifyByemail(String email,String password) {
		return repository.verifyUser(email,password);
	}
}
