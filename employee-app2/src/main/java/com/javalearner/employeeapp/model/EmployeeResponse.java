package com.javalearner.employeeapp.model;

public class EmployeeResponse {
	private int employeeId;
	private String firstname;
	private String lastname;
	private String email;
	private String bloodGroup;
	private AddressResponse addressResponse;

	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getBloodGroup() {
		return bloodGroup;
	}
	public void setBloodGroup(String bloodGroup) {
		this.bloodGroup = bloodGroup;
	}
	public AddressResponse getAddressResponse() {
		return addressResponse;
	}
	public void setAddressResponse(AddressResponse addressResponse) {
		this.addressResponse = addressResponse;
	}
	@Override
	public String toString() {
		return "EmployeeResponse [employeeId=" + employeeId + ", firstname=" + firstname + ", lastname=" + lastname
				+ ", email=" + email + ", bloodGroup=" + bloodGroup + ", addressResponse=" + addressResponse + "]";
	}
	
}
