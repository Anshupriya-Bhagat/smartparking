package com.grownited.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.grownited.Dto.Parkingdto;
import com.grownited.entity.ParkingEntity;
import com.grownited.entity.UserEntity;
import com.grownited.repository.ParkingRepository;
import com.grownited.repository.UserRepository;

@Controller
public class ParkingController {
	
	@Autowired
	ParkingRepository repoparking;
	
	@Autowired
	UserRepository repouser;
	
	
	
	@GetMapping(value= {"/","parking"})
	public String parking(Model model) {
		
		List<UserEntity> allusers  = repouser.findAll();
		 model.addAttribute("allusers", allusers);
		 
		return"Parking";
	}
	
	@PostMapping("saveparking")
	public String saveparking(ParkingEntity parking) {
		
		System.out.println(parking.getOtherInformation());
		System.out.println(parking.getTotalCapacityFourWheeler());
		System.out.println(parking.getTotalCapacityTwoWheeler());
		System.out.println(parking.getAddress());
		System.out.println(parking.getTitle());
		System.out.println(parking.getParkingType());
		parking.setActive("Active");
		parking.setHourlyChargeForFourWheeler(700);
		parking.setHourlyChargeForTwoWheeler(500);
		repoparking.save(parking);
		return "redirect:/listparking";
	}
	
	@GetMapping("listparking")
	public String listaprking(Model model) {
		
		//List<Parkingdto> allparking = repoparking.getAll();
		model.addAttribute("allparking",repoparking.getAll());
		
		return "ListParking";
	}
	
	@GetMapping("viewparking")
	public String viewlocation(Integer parkingId,Model model) {
		System.out.println("id==>" +parkingId);
		Optional<ParkingEntity> op = repoparking.findById(parkingId);
		if(op.isEmpty()) {
			
		}
		else {
			ParkingEntity parking = op.get();
			model.addAttribute("parking", parking);
			}
		return"ViewParking";
	}
	
	@GetMapping("deleteparking")
	public String deleteuser(Integer parkingId) {
		repoparking.deleteById(parkingId);
		return "redirect:/listparking";
	}
		
	

}
