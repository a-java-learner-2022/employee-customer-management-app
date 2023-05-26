package com.javalearner.addressapp.service;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javalearner.addressapp.dao.AddressRepository;
import com.javalearner.addressapp.entity.Address;
import com.javalearner.addressapp.model.AddressResponse;

@Service
public class AddressServiceImpl implements AddressService{
	
	private static final Logger LOGGER = LoggerFactory.getLogger(AddressServiceImpl.class);
	
	@Autowired
	private AddressRepository addressRepo;
	
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public AddressResponse findAddressByEmployeeId(int employeeId) {
		Address address = addressRepo.findAddressByEmployeeId(employeeId);
		
		if(address!=null) {
			AddressResponse addressResponse = modelMapper.map(address, AddressResponse.class);
			LOGGER.info(String.format("AddressService:=>  %s", addressResponse.toString()));
			return addressResponse;	
		}
		LOGGER.info(String.format("AddressService:=> %s", "NOT FOUND AddressResponse Object"));
		return null;
	}

}
