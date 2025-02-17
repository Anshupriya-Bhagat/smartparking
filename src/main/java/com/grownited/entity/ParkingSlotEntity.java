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
	private Integer parkingsslotId;
	private Long parkingId;
	private Integer floor;
	private Integer parkingTag;
	private Boolean active;
	private Integer minimumParkingMinutes;
	private String suvSupported;
	public Integer getParkingsslotId() {
		return parkingsslotId;
	}
	public void setParkingsslotId(Integer parkingsslotId) {
		this.parkingsslotId = parkingsslotId;
	}
	
	
	public Long getParkingId() {
		return parkingId;
	}
	public void setParkingId(Long parkingId) {
		this.parkingId = parkingId;
	}
	public Integer getFloor() {
		return floor;
	}
	public void setFloor(Integer floor) {
		this.floor = floor;
	}
	public Integer getParkingTag() {
		return parkingTag;
	}
	public void setParkingTag(Integer parkingTag) {
		this.parkingTag = parkingTag;
	}
	public Boolean getActive() {
		return active;
	}
	public void setActive(Boolean active) {
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
