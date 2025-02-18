package com.grownited.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
		System.out.println(vehicle.getVehicleType());
		System.out.println(vehicle.getRegistrationNum());
		repovehicle.save(vehicle);
		return ("Vehicle");
	}
	
	@GetMapping("listvehicle")
	public String listvehicle(Model model) {
		List<VehicleEntity> vehicleList = repovehicle .findAll();
		model.addAttribute("vehicleList", vehicleList);
		return("ListVehicle");
	}

}
