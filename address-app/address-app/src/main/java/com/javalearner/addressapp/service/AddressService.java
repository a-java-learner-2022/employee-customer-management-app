package com.javalearner.addressapp.service;

import com.javalearner.addressapp.model.AddressResponse;

public interface AddressService {

	public AddressResponse findAddressByEmployeeId(int employeeId);
}
