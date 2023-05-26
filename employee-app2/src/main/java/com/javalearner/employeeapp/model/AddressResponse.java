package com.javalearner.employeeapp.model;

public class AddressResponse {
	private int addressId;
	private String streetAddress;
	private String city;
	private String state;
	private int zipcode;
	public int getAddressId() {
		return addressId;
	}
	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}
	public String getStreetAddress() {
		return streetAddress;
	}
	public void setStreetAddress(String streetAddress) {
		this.streetAddress = streetAddress;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public int getZipcode() {
		return zipcode;
	}
	public void setZipcode(int zipcode) {
		this.zipcode = zipcode;
	}
	@Override
	public String toString() {
		return "AddressResponse [addressId=" + addressId + ", streetAddress=" + streetAddress + ", city=" + city
				+ ", state=" + state + ", zipcode=" + zipcode + "]";
	}
	
}
