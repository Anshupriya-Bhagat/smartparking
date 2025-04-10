package com.grownited.entity;


import java.sql.Date;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import jakarta.persistence.Table;

@Entity
@Table(name = "reservation")
public class ReservationEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer reservationId;
	private Integer userId;
	private Integer parkingId;
	private Integer locationId;
	private Integer vehicleId;
	private Date date;
	private String startTime;
	private String endTime;
	private String paymentStatus;
	private Integer amountPaid;
	private Integer securityAmountPaid;
	private Integer countReservationsFromLastMonth;
	private Integer startDate;
	private Integer endDate;
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
	public Integer getParkingId() {
		return parkingId;
	}
	public void setParkingId(Integer parkingId) {
		this.parkingId = parkingId;
	}
	
	public Integer getLocationId() {
		return locationId;
	}
	public void setLocationId(Integer locationId) {
		this.locationId = locationId;
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
	public Integer getCountReservationsFromLastMonth() {
		return countReservationsFromLastMonth;
	}
	public void setCountReservationsFromLastMonth(Integer countReservationsFromLastMonth) {
		this.countReservationsFromLastMonth = countReservationsFromLastMonth;
	}
	public Integer getStartDate() {
		return startDate;
	}
	public void setStartDate(Integer startDate) {
		this.startDate = startDate;
	}
	public Integer getEndDate() {
		return endDate;
	}
	public void setEndDate(Integer endDate) {
		this.endDate = endDate;
	}
	
	
}
