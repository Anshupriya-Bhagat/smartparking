package com.grownited.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;



import com.grownited.entity.UserEntity;
import com.grownited.entity.VehicleEntity;
import com.grownited.repository.UserRepository;
import com.grownited.repository.VehicleRepository;

import jakarta.servlet.http.HttpSession;

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
	public String savevehicle(VehicleEntity vehicle, HttpSession session) {
		
		
		UserEntity user = (UserEntity) session.getAttribute("user");// Object
		Integer userId = user.getUserId();

		vehicle.setUserId(userId);

		repovehicle.save(vehicle);
		
		return ("redirect:/listvehicle");
	}
	
	@GetMapping("listvehicle")
	public String listvehicle(Model model) {
		List<Object[]> allvehicle = repovehicle.getAll();
        model.addAttribute("allvehicle",allvehicle );
		return("ListVehicle");
	}
	
//	@GetMapping("listvehicle")
//	public String listvehicle(HttpSession session, Model model) {
//	    UserEntity user = (UserEntity) session.getAttribute("user");
//if (user == null) {
//	        return "redirect:/login";  
//	    }
//        
//	    List<Object[]> allvehicle = repovehicle.getAllByUserId(user.getUserId());
//	    model.addAttribute("allvehicle", allvehicle);
//
//	    return "ListVehicle";
//	}
//	
	@GetMapping("viewvehicle")
	public String viewvehicle(Integer vehicleId, Model model) {
		List<Object[]> op = repovehicle.getByVehicleId(vehicleId);
		model.addAttribute("vehicle", op);
		return"ViewVehicle";
	}
	
	@GetMapping("deletevehicle")
	public String deletevehicle(Integer vehicleId) {
		repovehicle.deleteById(vehicleId);
		return"redirect:/listvehicle";
	}
	

	@GetMapping("editvehicle")
	public String editVehicle(Integer vehicleId,Model model) {
		Optional<VehicleEntity> op = repovehicle.findById(vehicleId);
		if (op.isEmpty()) {
			return "redirect:/listvehicle";
		} else {
			model.addAttribute("vehicle",op.get());
			return "EditVehicle";

		}
	}
	
	@PostMapping("updatevehicle")
	public String updateVehicle(VehicleEntity vehicleEntity) {
		
		System.out.println(vehicleEntity.getVehicleId());

		Optional<VehicleEntity> op = repovehicle.findById(vehicleEntity.getVehicleId());
		
		if(op.isPresent())
		{
			VehicleEntity dbVehicle = op.get(); 
			dbVehicle.setRegistrationNum(vehicleEntity.getRegistrationNum()); 
			dbVehicle.setVehicleType(vehicleEntity.getVehicleType()); 
			
			repovehicle.save(dbVehicle);
		}
		return "redirect:/listvehicle";
	}
	
	
	
	

}
