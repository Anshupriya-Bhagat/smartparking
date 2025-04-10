package com.grownited.controller.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.grownited.entity.CityEntity;
import com.grownited.entity.LocationEntity;
import com.grownited.entity.StateEntity;
import com.grownited.repository.CityRepository;
import com.grownited.repository.LocationRepository;
import com.grownited.repository.StateRepository;

@Controller
public class AdminCityController {
	
	@Autowired
	CityRepository repocity;
	
	@Autowired
	LocationRepository repolocation;
	
	@GetMapping("adminaddcity")
    public String adminaddcity(Model model) {
		List<LocationEntity>alllocation=repolocation.findAll();
    	model.addAttribute("alllocation", alllocation);
		return("admindashboard/AdminAddCity");
	}
	
	@PostMapping("adminsavecity")
	public String adminsavecity(CityEntity city) {
		System.out.println(city.getCityName());
		repocity.save(city);
		return("redirect:/adminlistcity");
	}
	
	@GetMapping("adminlistcity")
	public String adminlistcity(Model model) {
		
		List<Object[]>allcity=repocity.getAll();
		model.addAttribute("allcity", allcity);
		return("admindashboard/AdminListCity");
	}
	
	@GetMapping("adminviewcity")
	public String adminviewcity(Integer cityId, Model model) {
		List<Object[]> op = repocity.getBycityId(cityId);
		model.addAttribute("city", op);
		return"admindashboard/AdminViewCity";
	}
	
	@GetMapping("admindeletcity")
	public String admindeletcity(Integer cityId) {
		repocity.deleteById(cityId);
		return"redirect:/adminlistcity";
	}

}
