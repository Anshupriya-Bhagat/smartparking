package com.grownited.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.grownited.entity.LocationEntity;

import com.grownited.repository.LocationRepository;

@Controller
public class LocationController {
	@Autowired
	LocationRepository repolocation;
	
	@GetMapping(value={"/","location"}) 
	public String location() {
		return "Location";
	}
	
	@PostMapping("savelocation")
	public String savelocation(LocationEntity location) {
		System.out.println(location.getLoctionName());
		repolocation.save(location);
		return ("redirect:/listlocation");
	}
	@GetMapping("listlocation")
	public String listLocation(Model model) {
		List<LocationEntity> locationList = repolocation.findAll();
		model.addAttribute("locationList", locationList);
		return "ListLocation";
	}
	
	@GetMapping("viewlocation")
	public String viewlocation(Integer locationId, Model model) {
		System.out.println("id ==>" +locationId);
		 Optional<LocationEntity> op= repolocation.findById(locationId);
		 if(op.isEmpty()) {
			 //data not found
		 }
		 else {
			 LocationEntity location = op.get();
			 model.addAttribute("location", location);
			 }
		
		return"ViewLocation";
	}
	
	@GetMapping("deletelocation")
	public String deletelocation(Integer locationId) {
		repolocation.deleteById(locationId);
		return"redirect:/listlocation";
	}

}
