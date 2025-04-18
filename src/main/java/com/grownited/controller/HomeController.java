package com.grownited.controller;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.grownited.entity.LocationEntity;
import com.grownited.entity.ParkingEntity;
import com.grownited.entity.UserEntity;
import com.grownited.repository.LocationRepository;
import com.grownited.repository.ParkingRepository;
import com.grownited.repository.ReservationRepository;
import com.grownited.repository.UserRepository;
import com.grownited.repository.VehicleRepository;

import jakarta.servlet.http.HttpSession;
@Controller
public class HomeController {
	
	@Autowired
	LocationRepository repolocation;
	
	@Autowired
	ParkingRepository repoparking;
	
	@Autowired
	UserRepository repouser;
	
	@Autowired
	VehicleRepository repovehicle;
	
	@Autowired
	ReservationRepository reporeservation;
	
	@GetMapping("home")
	public String home(HttpSession session,Model model ) {
		 UserEntity user = (UserEntity) session.getAttribute("user");
		    if (user != null) {
		        int userId = user.getUserId();
		        int totalReservations = reporeservation.countByUserId(userId);
		        model.addAttribute("totalReservations", totalReservations);
		    }
		    
		    if (user != null) {
		        int userId = user.getUserId();
		        int totalVehicles = repovehicle.countByUserId(userId);
		        model.addAttribute("totalVehicles", totalVehicles);
		    }
		    
		    if (user != null) {
//		        return "redirect:/login"; // redirect to login if user is not logged in
		    	 int userId = user.getUserId();
		    	 int pastCount = reporeservation.countPastReservations(userId);
				    int currentCount = reporeservation.countCurrentReservations(userId);

				    model.addAttribute("pastCount", pastCount);
				    model.addAttribute("currentCount", currentCount);
		    }

		   
		return"Home";
	}
	
	@GetMapping("selectlocation")
	public String selectlocation(Model model) {
		List<LocationEntity> alllocation  = repolocation.findAll();
		 model.addAttribute("alllocation", alllocation);
		return"SelectLocation";
	}
	
	@PostMapping("findparking")
	public String findparking(LocationEntity location) {
		
		return ("redirect:/listofparking");
	}
	
	@GetMapping("listofparking")
	public String listofparking(@RequestParam("locationId") int locationId, Model model) {
		
		List<Object[]>allparking=repoparking.findUniqueByLocation(locationId);
		model.addAttribute("allparking",allparking);
		return "ListOfParking";
	}
	
	@GetMapping("viewparking")
	public String viewparking(Integer parkingId,Model model) {
			List<Object[]> op = repoparking.getByParkingId(parkingId);
			model.addAttribute("parking", op);
			return"ViewParking";
		
	}
	
	@GetMapping("/edituser")
	public String editUser(HttpSession session, Model model) {
		UserEntity user = (UserEntity) session.getAttribute("user");
	    model.addAttribute("user", user);
	    return "EditUser";
	}
	
	@PostMapping("updateuser")
	public String updateuser(UserEntity user) {
		System.out.println(user.getUserId());
		
		Optional<UserEntity>op=repouser.findById(user.getUserId());
		
		if(op.isPresent()) {
			UserEntity dbuser=op.get();
			dbuser.setFirstName(user.getFirstName());
			dbuser.setLastName(user.getLastName());
			dbuser.setContactNum(user.getContactNum());
			repouser.save(dbuser);
		}return"redirect:/adminlistuser";
	}



}
