package com.bridgelabz.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

//userRegistration pojo class
public class RegistrationDetails {

	@NotNull
	// @Pattern(regexp="^[a-zA-Z]",message="please enter only letters")
	// //[A-Za-z]{3}"
	private String firstname;
	private String lastname;
	@NotNull
	private String password;
	@Size(min = 10, max = 10, message = "please enter 10 digits only")
	private String mobileNumber;
	private String emailId;
	private String gender;
	private String country;

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	// @NotNull(message="message")
	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	@Override
	public String toString() {
		return "RegistrationForm [firstname=" + firstname + "]";
	}

}
