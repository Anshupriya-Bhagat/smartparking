package com.grownited.controller;

import java.util.List;

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
		return("redirect:/newcity");
	}
}
