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
	private Integer locationId;
	private Integer ownerId;
	private Integer totalCapacityTwoWheeler;
	private Integer totalCapacityFourWheeler;
	private Integer otherInformation;
	private Integer active;
	private Integer hourlyChargeForTwoWheeler;
	private Integer hourlyChargeForFourWheeler;
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
	public Integer getLocationId() {
		return locationId;
	}
	public void setLocationId(Integer locationId) {
		this.locationId = locationId;
	}
	public Integer getOwnerId() {
		return ownerId;
	}
	public void setOwnerId(Integer ownerId) {
		this.ownerId = ownerId;
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
	public Integer getOtherInformation() {
		return otherInformation;
	}
	public void setOtherInformation(Integer otherInformation) {
		this.otherInformation = otherInformation;
	}
	public Integer getActive() {
		return active;
	}
	public void setActive(Integer active) {
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
	public String getParkingType() {
		return parkingType;
	}
	public void setParkingType(String parkingType) {
		this.parkingType = parkingType;
	}

	

}
