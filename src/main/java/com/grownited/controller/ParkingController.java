package com.grownited.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.grownited.entity.ParkingEntity;
import com.grownited.repository.ParkingRepository;

@Controller
public class ParkingController {
	
	@Autowired
	ParkingRepository repoparking;
	@GetMapping(value= {"/","parking"})
	public String parking() {
		return("Parking");
	}
	
	@PostMapping("saveparking")
	public String saveparking(ParkingEntity parking) {
		System.out.println(parking.getHourlyChargeForFourWheeler());
		System.out.println(parking.getHourlyChargeForTwoWheeler());
		System.out.println(parking.getOtherInformation());
		System.out.println(parking.getTotalCapacityFourWheeler());
		System.out.println(parking.getTotalCapacityTwoWheeler());
		System.out.println(parking.getAddress());
		System.out.println(parking.getTitle());
		System.out.println(parking.getActive());
		System.out.println(parking.getParkingType());
		repoparking.save(parking);
		return ("Parking");
	}
		
	

}
