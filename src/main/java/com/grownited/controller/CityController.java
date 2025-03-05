package com.grownited.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.grownited.Dto.Citydto;
import com.grownited.entity.CityEntity;
import com.grownited.entity.StateEntity;
import com.grownited.repository.CityRepository;
import com.grownited.repository.StateRepository;

@Controller
public class CityController {
	
	@Autowired
	StateRepository repoState;
	
	@Autowired
	CityRepository repocity;
	
	@GetMapping("newcity")
    public String city(Model model) {
		List<StateEntity> allstate =repoState.findAll();
		model.addAttribute("allstate", allstate);
		return("NewCity");
	}
	
	@PostMapping("savecity")
	public String savecity(CityEntity city) {
		System.out.println(city.getCityName());
		repocity.save(city);
		return("redirect:/newcity");
	}
	
	@GetMapping("listcity")
	public String listcity(Model model) {
		
		
		List<Citydto> allcity = repocity.getAll();

		model.addAttribute("allcity", repocity.getAll());
		
		return("ListCity");
	}
	
	@GetMapping("viewcity")
	public String viewlocation(Integer cityId, Model model) {
		System.out.println("id ==>" +cityId);
		 Optional<CityEntity> op= repocity.findById(cityId);
		 if(op.isEmpty()) {
			 //data not found
		 }
		 else {
			 CityEntity city = op.get();
			 model.addAttribute("city", city);
			 }
		
		return"ViewCity";
	}
	
	@GetMapping("deletecity")
	public String deletecity(Integer cityId) {
		repocity.deleteById(cityId);
		return"redirect:/listcity";
	}
	
	
	
	
}
