package com.namoo.excel;

public class Address {
	//
	private String name;
	private String phone;
	private String address;
	
	//-----------------------------------------------------------------------------
	// constructor
	
	public Address() {
		//
	}
	
	public Address(String name, String phone, String address) {
		//
		this.name = name;
		this.phone = phone;
		this.address = address;
	}
	
	//-----------------------------------------------------------------------------
	// getter, setter
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
}
