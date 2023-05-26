package com.javalearner.addressapp.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.javalearner.addressapp.model.AddressResponse;
import com.javalearner.addressapp.service.AddressService;

@RestController
//@RequestMapping("")
public class AddressController {
	
	public static final Logger LOGGER = LoggerFactory.getLogger(AddressController.class);
	
	@Autowired
	private AddressService addressService;
	
	@GetMapping()
	public String getAddress() {
		return "Woodside, NY 11377";
	}
	
	@GetMapping("/address/{employeeId}")
	public ResponseEntity<AddressResponse> getAddressByEmployeeId(@PathVariable("employeeId") int employeeId) {
		AddressResponse addressResponse = addressService.findAddressByEmployeeId(employeeId);
		
		if (addressResponse!=null) {
			LOGGER.info(String.format("AddressController: => %s", addressResponse.toString()));
			return ResponseEntity.status(HttpStatus.OK).body(addressResponse);
		}
		LOGGER.info(String.format("AddressController: => %s", "NOT FOUND AddressResponse Object"));
		return ResponseEntity.status(HttpStatus.NO_CONTENT).body(addressResponse);
		
	}

}
