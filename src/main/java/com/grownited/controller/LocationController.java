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
	public String location(Model model) {
		List<LocationEntity> alllocation  = repolocation.findAll();
		 model.addAttribute("alllocation", alllocation);
		return "Location";
	}
	
//	@PostMapping("savelocation")
//	public String savelocation(LocationEntity location) {
//		System.out.println(location.getLoctionName());
//		repolocation.save(location);
//		return ("redirect:/listlocation");
//	}
//	@GetMapping("listlocation")
//	public String listLocation(Model model) {
//		List<LocationEntity> locationList = repolocation.findAll();
//		model.addAttribute("locationList", locationList);
//		return "ListLocation";
//	}
	
	@GetMapping("viewlocation")
	public String viewlocation(Integer locationId, Model model) {
		List<Object[]>op=repolocation.getByLocationId(locationId);
		model.addAttribute("location", op);
		return"ViewLocation";
	}
	
	@GetMapping("deletelocation")
	public String deletelocation(Integer locationId) {
		repolocation.deleteById(locationId);
		return"redirect:/listlocation";
	}
	
	@GetMapping("editlocation")
	public String editlocation(Integer locationId,Model model,LocationEntity location) {
		Optional<LocationEntity> op = repolocation.findById(locationId);
		if (!op.isPresent()) {
			return "redirect:/listlocation";
		} else {
			//System.out.println(location.getLocationId());
			model.addAttribute("location",op.get());
			return "EditLocation";

		}
	}
	
	@PostMapping("updatelocation")
	public String updatelocation(LocationEntity location,Integer locationId) {
		
		System.out.println(locationId);
		System.out.println(location.getLocationId()); 
		System.out.println(location.getLoctionName());
		
		Optional<LocationEntity> op = repolocation.findById(location.getLocationId());
		
		if(op.isPresent())
		{
			LocationEntity dblocation = op.get(); 
			dblocation.setLoctionName(location.getLoctionName());//code 
			
			repolocation.save(dblocation);
		}
		return "redirect:/listlocation";
	}
	
	

}
