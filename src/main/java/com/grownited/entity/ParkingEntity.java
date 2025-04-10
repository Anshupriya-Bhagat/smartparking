package com.grownited.entity;



import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="parking")
public class ParkingEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer parkingId;
	private String title;
	private String address;
	private Integer userId;
	private Integer locationId;
	private Integer totalCapacityTwoWheeler;
	private Integer totalCapacityFourWheeler;
	private String otherInformation;
	private String active;
	private Integer hourlyChargeForTwoWheeler;
	private Integer hourlyChargeForFourWheeler;
	private Float longitude;
	private Float latitude;
	private String parkingType;
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
	
	public Integer getLocationId() {
		return locationId;
	}
	public void setLocationId(Integer locationId) {
		this.locationId = locationId;
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
	

	

}
