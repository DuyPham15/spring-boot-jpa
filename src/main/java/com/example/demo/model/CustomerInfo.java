package com.example.demo.model;

public class CustomerInfo {

	private String firstName;
	private String lastName;
	private String address;
	private String ward;
	private String district;
	private String city;
	private String email;
	private String numberPhone;
	private boolean valid;

	public CustomerInfo() {
	}

	public CustomerInfo(CustomerForm customerForm) {
		this.firstName = customerForm.getFirstName();
		this.lastName = customerForm.getLastName();
		this.address = customerForm.getAddress();
		this.ward = customerForm.getWard();
		this.district = customerForm.getDistrict();
		this.city = customerForm.getCity();
		this.email = customerForm.getEmail();
		this.numberPhone = customerForm.getNumberPhone();
		this.valid = customerForm.isValid();
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}	

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getWard() {
		return ward;
	}

	public void setWard(String ward) {
		this.ward = ward;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNumberPhone() {
		return numberPhone;
	}

	public void setNumberPhone(String numberPhone) {
		this.numberPhone = numberPhone;
	}

	public boolean isValid() {
		return valid;
	}

	public void setValid(boolean valid) {
		this.valid = valid;
	}
}
