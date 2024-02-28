package org.jsp.springbootmockuser.controller;

import org.jsp.springbootmockuser.dto.Address;
import org.jsp.springbootmockuser.dto.ResponseStructure;
import org.jsp.springbootmockuser.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AddressController {
	@Autowired
	private AddressService addressService;

	@PostMapping("/addresses/{userid}")
	public ResponseEntity<ResponseStructure<Address>> saveAddress(@RequestBody Address address,
			@PathVariable(name = "userid") int userid) {
		return addressService.saveAddress(address, userid);

	}

	@PutMapping("/address")
	public ResponseEntity<ResponseStructure<Address>> updateAddress(@RequestBody Address address) {
		return addressService.updateAddress(address);
	}

	@GetMapping("/addresses/{id}")
	public ResponseEntity<ResponseStructure<Address>> updateAddress(@PathVariable int id) {
		return addressService.findById(id);
	}
}