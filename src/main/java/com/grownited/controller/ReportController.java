package com.grownited.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.grownited.entity.UserEntity;
import com.grownited.repository.ReservationRepository;
import com.grownited.repository.VehicleRepository;

import jakarta.servlet.http.HttpSession;

@Controller
public class ReportController {
	
	@Autowired
	ReservationRepository reporeservation;
	
	@Autowired
	VehicleRepository repovehicle;
	
	@GetMapping("reportreservation")
	public String reportreservation(HttpSession session, Model model) {
		
		 UserEntity user = (UserEntity) session.getAttribute("user");

		    if (user == null) {
		        return "redirect:/login";  
		    }
	        
		    List<Object[]> reservationList = reporeservation.getAllByUserId(user.getUserId());    
		    model.addAttribute("reservationList", reservationList);
		return"ReportReservation";
	}
	
	@GetMapping("reportvehicle")
	public String reportvehicle(HttpSession session, Model model) {
		
		 UserEntity user = (UserEntity) session.getAttribute("user");

		    if (user == null) {
		        return "redirect:/login";  
		    }
	        
		    List<Object[]> allvehicle = repovehicle.getAllByUserId(user.getUserId());    
		    model.addAttribute("allvehicle", allvehicle);
		return"ReportVehicle";
	}

}
