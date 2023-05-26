package com.javalearner.employeeapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.javalearner.employeeapp.model.EmployeeResponse;
import com.javalearner.employeeapp.service.EmployeeService;

@RestController
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

//	@Autowired
//	private RestTemplate restTemplate;

//	@GetMapping()
//	public String getEmployee() {
//
//		//return the address data along with employee data
//
//		//get the data from address service by hitting this http://localhost:8080/address
//		String address=restTemplate.getForObject("http://localhost:8080/address",String.class);
//		return "Name: Durga Maharjan, email: durgamaharjan@gmail.com " + address;
//	}

	@GetMapping("/employees/{employeeId}")
	public ResponseEntity<EmployeeResponse> findEmployeeById(@PathVariable("employeeId") int employeeId) {
		EmployeeResponse employeeResponse = employeeService.findEmployeeAndAddressByEmployeeId(employeeId);
		
		if (employeeResponse!=null) {
			return ResponseEntity.status(HttpStatus.OK).body(employeeResponse);
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);

	}

}
