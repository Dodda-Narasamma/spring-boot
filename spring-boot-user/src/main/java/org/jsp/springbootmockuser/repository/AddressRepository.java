package org.jsp.springbootmockuser.repository;

import java.util.Optional;

import org.jsp.springbootmockuser.dto.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Integer>{
	
//	public Optional<Address> findByUserId(int userid);

}