package com.grownited.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
		
		System.out.println(parking.getOtherInformation());
		System.out.println(parking.getTotalCapacityFourWheeler());
		System.out.println(parking.getTotalCapacityTwoWheeler());
		System.out.println(parking.getAddress());
		System.out.println(parking.getTitle());
		
		System.out.println(parking.getParkingType());
		repoparking.save(parking);
		return ("Parking");
	}
	
	@GetMapping("listparking")
	public String listaprking(Model model) {
		List<ParkingEntity> parkingList = repoparking.findAll();	
		model.addAttribute("parkingList", parkingList);
		return ("ListParking");
	}
		
	

}
