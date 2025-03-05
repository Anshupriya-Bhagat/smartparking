package com.grownited.Dto;

public class Citydto {
	
	private Integer cityId;
	private String cityName;
	private Integer stateID;
	private String stateName;
	public Citydto(Integer cityId, String cityName, Integer stateID, String stateName) {
		super();
		this.cityId = cityId;
		this.cityName = cityName;
		this.stateID = stateID;
		this.stateName = stateName;
	}
	public Integer getCityId() {
		return cityId;
	}
	public void setCityId(Integer cityId) {
		this.cityId = cityId;
	}
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	public Integer getStateID() {
		return stateID;
	}
	public void setStateID(Integer stateID) {
		this.stateID = stateID;
	}
	public String getStateName() {
		return stateName;
	}
	public void setStateName(String stateName) {
		this.stateName = stateName;
	}
	
	
		
		
		
	
	

}
