package com.grownited.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.grownited.entity.VehicleEntity;
import com.grownited.repository.VehicleRepository;

@Controller
public class VehicleController {
	
	@Autowired
	VehicleRepository repovehicle;
	@GetMapping(value= {"/","vehicle"})
	public String vehicle() {
		return ("Vehicle");
	}
	
	@PostMapping("savevehicle")
	public String savevehicle(VehicleEntity vehicle) {
		System.out.println(vehicle.getVehicletype());
		System.out.println(vehicle.getRegistrationNum());
		repovehicle.save(vehicle);
		return ("Signup");
	}

}
