package com.grownited.entity;



import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "parkingslot")
public class ParkingSlotEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer parkingSlotId;
	private Long parkingId;
	private String floor;
	private Integer parkingTag;
	private String active;
	private Integer minimumParkingMinutes;
	private String suvSupported;
	
	
	
	public Integer getParkingSlotId() {
		return parkingSlotId;
	}
	public void setParkingSlotId(Integer parkingSlotId) {
		this.parkingSlotId = parkingSlotId;
	}
	public Long getParkingId() {
		return parkingId;
	}
	public void setParkingId(Long parkingId) {
		this.parkingId = parkingId;
	}
	public String getFloor() {
		return floor;
	}
	public void setFloor(String floor) {
		this.floor = floor;
	}
	public Integer getParkingTag() {
		return parkingTag;
	}
	public void setParkingTag(Integer parkingTag) {
		this.parkingTag = parkingTag;
	}
	
	public String getActive() {
		return active;
	}
	public void setActive(String active) {
		this.active = active;
	}
	public Integer getMinimumParkingMinutes() {
		return minimumParkingMinutes;
	}
	public void setMinimumParkingMinutes(Integer minimumParkingMinutes) {
		this.minimumParkingMinutes = minimumParkingMinutes;
	}
	public String getSuvSupported() {
		return suvSupported;
	}
	public void setSuvSupported(String suvSupported) {
		this.suvSupported = suvSupported;
	}


}
