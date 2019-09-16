package com.company.module.RestAPIAutomation.requestpojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * POJO class used for put call
 * @param address
 */
public class UpdatePersonPojo {
	
	@SerializedName("name")
	@Expose
	private String name;
	@SerializedName("surname")
	@Expose
	private String surname;
	@SerializedName("address")
	@Expose
	private Address address;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

}

