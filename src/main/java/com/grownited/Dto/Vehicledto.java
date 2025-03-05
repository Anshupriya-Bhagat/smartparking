package com.grownited.Dto;

public class Vehicledto {
	
	private Integer vehicleId;
	private Integer userId;
	private String registrationNum;
	private String vehicleType;
	private String firstName;
	private String lastName;
	private String email;
	private Integer contactNum;
	private String password;
	public Vehicledto(Integer vehicleId, Integer userId, String registrationNum, String vehicleType, String firstName,
			String lastName, String email, Integer contactNum, String password) {
		super();
		this.vehicleId = vehicleId;
		this.userId = userId;
		this.registrationNum = registrationNum;
		this.vehicleType = vehicleType;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.contactNum = contactNum;
		this.password = password;
	}
	public Integer getVehicleId() {
		return vehicleId;
	}
	public void setVehicleId(Integer vehicleId) {
		this.vehicleId = vehicleId;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getRegistrationNum() {
		return registrationNum;
	}
	public void setRegistrationNum(String registrationNum) {
		this.registrationNum = registrationNum;
	}
	public String getVehicleType() {
		return vehicleType;
	}
	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Integer getContactNum() {
		return contactNum;
	}
	public void setContactNum(Integer contactNum) {
		this.contactNum = contactNum;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
		
	
	
		
	
	
	

}
