package com.grownited.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


import com.grownited.Dto.Vehicledto;
import com.grownited.entity.UserEntity;
import com.grownited.entity.VehicleEntity;
import com.grownited.repository.UserRepository;
import com.grownited.repository.VehicleRepository;

@Controller
public class VehicleController {
	
	@Autowired
	VehicleRepository repovehicle;
	
	@Autowired
	UserRepository repouser;
	
	@GetMapping(value= {"/","vehicle"})
	public String vehicle(Model model) {
		
		 List<UserEntity> allusers  = repouser.findAll();
		 model.addAttribute("allusers", allusers);
		return ("Vehicle");
	}
	
	@PostMapping("savevehicle")
	public String savevehicle(VehicleEntity vehicle) {
		System.out.println(vehicle.getVehicleType());
		System.out.println(vehicle.getRegistrationNum());
		repovehicle.save(vehicle);
		return ("redirect:/listvehicle");
	}
	
	@GetMapping("listvehicle")
	public String listvehicle(Model model) {
		List<Vehicledto> allvehicle = repovehicle.getAll();

		model.addAttribute("allvehicle", repovehicle.getAll());
		return("ListVehicle");
	}
	
	@GetMapping("viewvehicle")
	public String viewvehicle(Integer vehicleId, Model model) {
		System.out.println("id ==>" +vehicleId);
		Optional<VehicleEntity> op = repovehicle.findById(vehicleId);
		if(op.isEmpty()) {
			
		}
		else {
			VehicleEntity vehicle = op.get();
			model.addAttribute("vehicle", vehicle);
			}
		return"ViewVehicle";
	}
	
	@GetMapping("deletevehicle")
	public String deletevehicle(Integer vehicleId) {
		repovehicle.deleteById(vehicleId);
		return"redirect:/listvehicle";
	}
	
	
	
	

}
