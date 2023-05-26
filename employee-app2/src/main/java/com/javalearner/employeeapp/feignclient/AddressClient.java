package com.javalearner.employeeapp.feignclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.javalearner.employeeapp.model.AddressResponse;

//localhost:8080/address-app/api/address/1
@FeignClient(name = "abc",url ="${address-service.base.url}")
public interface AddressClient {// proxy 

	@GetMapping("/address/{employeeId}")
	AddressResponse getAddressByEmployeeId(@PathVariable("employeeId") int employeeId);
		
}
