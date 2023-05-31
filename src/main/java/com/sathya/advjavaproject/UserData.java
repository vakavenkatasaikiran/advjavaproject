package com.sathya.advjavaproject;

public class UserData {
	private String username;
	private String password;
	private String email;
	private String country;
	private String qualification;
	private String gender; 
	private String technologies; 
	private String address;
	private String comments;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getQualification() {
		return qualification;
	}
	public void setQualification(String qualification) {
		this.qualification = qualification;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getTechnologies() {
		return technologies;
	}
	public void setTechnologies(String technologies) {
		this.technologies = technologies;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	public UserData(String username, String password, String email, String country, String qualification, String gender,
			String technologies, String address, String comments) {
		super();
		this.username = username;
		this.password = password;
		this.email = email;
		this.country = country;
		this.qualification = qualification;
		this.gender = gender;
		this.technologies = technologies;
		this.address = address;
		this.comments = comments;
	}
	@Override
	public String toString() {
		return "UserData [username=" + username + ", password=" + password + ", email=" + email + ", country=" + country
				+ ", qualification=" + qualification + ", gender=" + gender + ", technologies=" + technologies
				+ ", address=" + address + ", comments=" + comments + "]";
	}
}
