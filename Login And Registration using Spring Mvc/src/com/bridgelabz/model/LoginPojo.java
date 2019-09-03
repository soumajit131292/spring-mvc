package com.bridgelabz.model;


//Login details pojo class
public class LoginPojo {

	  private String firstname;
	  private String password;
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "LoginPojo [firstname=" + firstname + ", password=" + password + "]";
	}
	  
	
	
}
