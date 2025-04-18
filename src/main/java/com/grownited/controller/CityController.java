package com.grownited.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


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
		return("redirect:/listcity");
	}
	
	@GetMapping("listcity")
	public String listcity(Model model) {
		
		List<Object[]>allcity=repocity.getAll();
		model.addAttribute("allcity", allcity);
		return("ListCity");
	}
	
	@GetMapping("viewcity")
	public String viewlocation(Integer cityId, Model model) {
		List<Object[]>op=repocity.getBycityId(cityId);
		model.addAttribute("city", op);
		
		return"ViewCity";
	}
	
	@GetMapping("deletecity")
	public String deletecity(Integer cityId) {
		repocity.deleteById(cityId);
		return"redirect:/listcity";
	}
	
	@GetMapping("editcity")
	public String editcity(Integer cityId,Model model) {
		Optional<CityEntity>op=repocity.findById(cityId);
		if(!op.isPresent()) {
			return"redirect:/listcity";
		}else {
			model.addAttribute("city", op.get());
			return"EditCity";
		}
	}
	
	@PostMapping("updatecity")
	public String updatecity(CityEntity city) {
		Optional<CityEntity>op=repocity.findById(city.getCityId());
		if(op.isPresent()) {
			CityEntity dbcity=op.get();
			dbcity.setCityName(city.getCityName());
			repocity.save(dbcity);
		}return"redirect:/listcity";
	}
	
	
	
	
}
