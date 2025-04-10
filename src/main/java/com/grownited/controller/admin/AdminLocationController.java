package com.grownited.controller.admin;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.grownited.entity.CityEntity;
import com.grownited.entity.LocationEntity;
import com.grownited.entity.StateEntity;
import com.grownited.entity.VehicleEntity;
import com.grownited.repository.CityRepository;
import com.grownited.repository.LocationRepository;

@Controller
public class AdminLocationController {
	
	@Autowired
	LocationRepository repolocation;
	
	@Autowired
	CityRepository repocity;
	
	@GetMapping("adminaddlocation")
	public String adminaddlocation(Model model) {
		List<CityEntity> allcity =repocity.findAll();
		model.addAttribute("allcity", allcity);
		return"admindashboard/AdminAddLocation";
	}
	
	@PostMapping("adminsavelocation")
	public String adminsavelocation(LocationEntity location) {
		System.out.println(location.getLoctionName());
		repolocation.save(location);
		return ("redirect:/adminlistlocation");
	}
	@GetMapping("adminlistlocation")
	public String adminlistLocation(Model model) {
		List<LocationEntity> locationList = repolocation.findAll();
		model.addAttribute("locationList", locationList);
		return "admindashboard/AdminListLocation";
	}
	
	@GetMapping("adminviewlocation")
	public String adminviewlocation(Integer locationId, Model model) {
		List<Object[]> op = repolocation.getByLocationId(locationId);
		model.addAttribute("location", op);
		return"admindashboard/AdminViewLocation";
	}
	
	@GetMapping("admindeletlocation")
	public String admindeletlocation(Integer locationId) {
		repolocation.deleteById(locationId);
		return"redirect:/adminlislocation";
	}
	

	

}
