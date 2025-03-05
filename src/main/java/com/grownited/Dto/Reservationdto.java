package com.grownited.Dto;

import java.sql.Date;

public class Reservationdto {
	
	private Integer reservationId;
	private Integer userId;
	private Integer parkingSlotId;
	private Integer parkingId;
	private Integer vehicleId;
	private Date date;
	private String startTime;
	private String endTime;
	private String paymentStatus;
	private Integer amountPaid;
	private Integer securityAmountPaid;
	private String firstName;
	private String reservationNum;
	private String title;
	private String floor;
	public Reservationdto(Integer reservationId, Integer userId, Integer parkingSlotId, Integer parkingId,
			Integer vehicleId, Date date, String startTime, String endTime, String paymentStatus, Integer amountPaid,
			Integer securityAmountPaid, String firstName, String reservationNum, String title, String floor) {
		super();
		this.reservationId = reservationId;
		this.userId = userId;
		this.parkingSlotId = parkingSlotId;
		this.parkingId = parkingId;
		this.vehicleId = vehicleId;
		this.date = date;
		this.startTime = startTime;
		this.endTime = endTime;
		this.paymentStatus = paymentStatus;
		this.amountPaid = amountPaid;
		this.securityAmountPaid = securityAmountPaid;
		this.firstName = firstName;
		this.reservationNum = reservationNum;
		this.title = title;
		this.floor = floor;
	}
	public Integer getReservationId() {
		return reservationId;
	}
	public void setReservationId(Integer reservationId) {
		this.reservationId = reservationId;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public Integer getParkingSlotId() {
		return parkingSlotId;
	}
	public void setParkingSlotId(Integer parkingSlotId) {
		this.parkingSlotId = parkingSlotId;
	}
	public Integer getParkingId() {
		return parkingId;
	}
	public void setParkingId(Integer parkingId) {
		this.parkingId = parkingId;
	}
	public Integer getVehicleId() {
		return vehicleId;
	}
	public void setVehicleId(Integer vehicleId) {
		this.vehicleId = vehicleId;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	public String getPaymentStatus() {
		return paymentStatus;
	}
	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}
	public Integer getAmountPaid() {
		return amountPaid;
	}
	public void setAmountPaid(Integer amountPaid) {
		this.amountPaid = amountPaid;
	}
	public Integer getSecurityAmountPaid() {
		return securityAmountPaid;
	}
	public void setSecurityAmountPaid(Integer securityAmountPaid) {
		this.securityAmountPaid = securityAmountPaid;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getReservationNum() {
		return reservationNum;
	}
	public void setReservationNum(String reservationNum) {
		this.reservationNum = reservationNum;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getFloor() {
		return floor;
	}
	public void setFloor(String floor) {
		this.floor = floor;
	}
	
		
		
	
	
	

}
