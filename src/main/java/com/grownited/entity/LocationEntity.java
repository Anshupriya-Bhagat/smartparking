package com.grownited.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "location")
public class LocationEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer locationId;
	private String loctionName;
	public Integer getLocationId() {
		return locationId;
	}
	public void setLoctionId(Integer locationId) {
		this.locationId = locationId;
	}
	public String getLoctionName() {
		return loctionName;
	}
	public void setLoctionName(String locationName) {
		this.loctionName = locationName;
	}
	

	
}
