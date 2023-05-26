package com.javalearner.addressapp.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.javalearner.addressapp.entity.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address,Integer> {

	//find address based on an employee_id
	@Query(nativeQuery = true, value = "SELECT ea.address_id,ea.street_address,ea.city,ea.state,ea.zipcode "
			+ "FROM javalearner_db.address_tbl AS ea "
			+ "join javalearner_db.employee_tbl e "
			+ "on e.employee_id=ea.employee_id "
			+ "where e.employee_id=:employeeId")
	Address findAddressByEmployeeId(@Param("employeeId") int employeeId);
}
