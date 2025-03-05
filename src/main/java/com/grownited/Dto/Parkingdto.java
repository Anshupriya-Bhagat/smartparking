package com.grownited.Dto;

public class Parkingdto {
	
	private Integer parkingId;
	private String title;
	private String address;
	private Integer userId;
	private Integer totalCapacityTwoWheeler;
	private Integer totalCapacityFourWheeler;
	private String otherInformation;
	private String active;
	private Integer hourlyChargeForTwoWheeler;
	private Integer hourlyChargeForFourWheeler;
	private Float longitude;
	private Float latitude;
	private String parkingType;
	private String firstName;
	private String lastName;
	private String email;
	private String gender;
	private Integer contactNum;
	
	public Parkingdto(Integer parkingId, String title, String address, Integer userId, Integer totalCapacityTwoWheeler,
			Integer totalCapacityFourWheeler, String otherInformation, String active, Integer hourlyChargeForTwoWheeler,
			Integer hourlyChargeForFourWheeler, Float longitude, Float latitude, String parkingType, String firstName,
			String lastName, String email, String gender, Integer contactNum) {
		super();
		this.parkingId = parkingId;
		this.title = title;
		this.address = address;
		this.userId = userId;
		this.totalCapacityTwoWheeler = totalCapacityTwoWheeler;
		this.totalCapacityFourWheeler = totalCapacityFourWheeler;
		this.otherInformation = otherInformation;
		this.active = active;
		this.hourlyChargeForTwoWheeler = hourlyChargeForTwoWheeler;
		this.hourlyChargeForFourWheeler = hourlyChargeForFourWheeler;
		this.longitude = longitude;
		this.latitude = latitude;
		this.parkingType = parkingType;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.gender = gender;
		this.contactNum = contactNum;
	}
	public Integer getParkingId() {
		return parkingId;
	}
	public void setParkingId(Integer parkingId) {
		this.parkingId = parkingId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public Integer getTotalCapacityTwoWheeler() {
		return totalCapacityTwoWheeler;
	}
	public void setTotalCapacityTwoWheeler(Integer totalCapacityTwoWheeler) {
		this.totalCapacityTwoWheeler = totalCapacityTwoWheeler;
	}
	public Integer getTotalCapacityFourWheeler() {
		return totalCapacityFourWheeler;
	}
	public void setTotalCapacityFourWheeler(Integer totalCapacityFourWheeler) {
		this.totalCapacityFourWheeler = totalCapacityFourWheeler;
	}
	public String getOtherInformation() {
		return otherInformation;
	}
	public void setOtherInformation(String otherInformation) {
		this.otherInformation = otherInformation;
	}
	public String getActive() {
		return active;
	}
	public void setActive(String active) {
		this.active = active;
	}
	public Integer getHourlyChargeForTwoWheeler() {
		return hourlyChargeForTwoWheeler;
	}
	public void setHourlyChargeForTwoWheeler(Integer hourlyChargeForTwoWheeler) {
		this.hourlyChargeForTwoWheeler = hourlyChargeForTwoWheeler;
	}
	public Integer getHourlyChargeForFourWheeler() {
		return hourlyChargeForFourWheeler;
	}
	public void setHourlyChargeForFourWheeler(Integer hourlyChargeForFourWheeler) {
		this.hourlyChargeForFourWheeler = hourlyChargeForFourWheeler;
	}
	public Float getLongitude() {
		return longitude;
	}
	public void setLongitude(Float longitude) {
		this.longitude = longitude;
	}
	public Float getLatitude() {
		return latitude;
	}
	public void setLatitude(Float latitude) {
		this.latitude = latitude;
	}
	public String getParkingType() {
		return parkingType;
	}
	public void setParkingType(String parkingType) {
		this.parkingType = parkingType;
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
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Integer getContactNum() {
		return contactNum;
	}
	public void setContactNum(Integer contactNum) {
		this.contactNum = contactNum;
	}
	
	
	
	
	

}
