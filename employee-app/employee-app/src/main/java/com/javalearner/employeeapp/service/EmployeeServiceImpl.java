package com.javalearner.employeeapp.service;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.javalearner.employeeapp.dao.EmployeeRepository;
import com.javalearner.employeeapp.entity.Employee;
import com.javalearner.employeeapp.model.AddressResponse;
import com.javalearner.employeeapp.model.EmployeeResponse;

@Service
public class EmployeeServiceImpl implements EmployeeService{
	
	private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeServiceImpl.class);
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private RestTemplate restTemplate;

	@Override
	public EmployeeResponse findEmployeeAndAddressByEmployeeId(int employeeId) {
		Optional<Employee> optional=employeeRepository.findById(employeeId);
		
		if (optional.isPresent()) {
			Employee employee = optional.get();
			EmployeeResponse employeeResponse = modelMapper.map(employee, EmployeeResponse.class);
			AddressResponse addressResponse = restTemplate.getForObject("http://localhost:8080/address-app/api/address/{employeeId}", AddressResponse.class,employeeId);
			employeeResponse.setAddressResponse(addressResponse);
			LOGGER.info(String.format("EMPLOYEE SERVICE: => %s", employeeResponse.toString()));
			//BeanUtils.copyProperties(employee, employeeResponse);
			return employeeResponse;
		}
		return null;
	}

}
