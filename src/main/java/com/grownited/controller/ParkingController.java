package com.grownited.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.grownited.entity.LocationEntity;
import com.grownited.entity.ParkingEntity;
import com.grownited.entity.UserEntity;
import com.grownited.entity.VehicleEntity;
import com.grownited.repository.CityRepository;
import com.grownited.repository.LocationRepository;
import com.grownited.repository.ParkingRepository;
import com.grownited.repository.UserRepository;
import com.grownited.repository.VehicleRepository;

import jakarta.servlet.http.HttpSession;


@Controller
public class ParkingController {
	
	@Autowired
	ParkingRepository repoparking;
	
	@Autowired
	UserRepository repouser;
	
	@Autowired
	LocationRepository repolocation;
	
	@Autowired
	CityRepository repocity;
	
	@Autowired
	VehicleRepository repovehicle;
	
	@GetMapping(value= {"/","parking"})
	public String parking(Model model) {
		
		List<UserEntity> allusers  = repouser.findAll();
		 model.addAttribute("allusers", allusers);
		 
		 List<LocationEntity> alllocation  = repolocation.findAll();
		 model.addAttribute("alllocation", alllocation);
		 
		return"Parking";
	}
	
	
	
//	@GetMapping("/bookparking")
//	public String showReservationForm(Model model) {
//	    model.addAttribute("allparkings", repoparking.findAll());
//	    model.addAttribute("allcity", repocity.findAll());
//	    model.addAttribute("alllocations", repolocation.findAll());
//	    model.addAttribute("allvehicles", repovehicle.findAll());
//	    return "Reservation";
//	}



	
	 
//	
//	@PostMapping("saveparking")
//	public String saveparking(ParkingEntity parking, HttpSession session) {
//		UserEntity user =(UserEntity) session.getAttribute("user");
//		Integer userId=user.getUserId();
//		parking.setUserId(userId);
//		parking.setActive("Active");
//		parking.setHourlyChargeForFourWheeler(700);
//		parking.setHourlyChargeForTwoWheeler(500);
//		repoparking.save(parking);
//		return "redirect:/ListParkingOwner";
//	}
	
	@GetMapping("listparking")
	public String listparking( Long parkingId,Model model) {
		
		List<Object[]> allparking = repoparking.getAll();
		model.addAttribute("allparking",allparking);
		
		return "ListParking";
	}


//@GetMapping("/listparking")
//public String listreservation(HttpSession session, Model model) {
//    UserEntity user = (UserEntity) session.getAttribute("user");
//
//    if (user == null) {
//        return "redirect:/login";  
//    }
//    
//    List<Object[]> allparking = repoparking.getAllByUserId(user.getUserId());
//    model.addAttribute("allparking", allparking);
//
//    return ("ListParking");
//}


	
//	@GetMapping("viewparking")
//	public String viewparking(Integer parkingId,Model model) {
//		List<Object[]> op = repoparking.getByParkingId(parkingId);
//		model.addAttribute("parking", op);
//		return"ViewParking";
//	}
//	
//	@GetMapping("deleteparking")
//	public String deleteuser(Integer parkingId) {
//		repoparking.deleteById(parkingId);
//		return "redirect:/listparking";
//	}
//	
//	@GetMapping("editparking")
//	public String editparking(Integer parkingId,Model model) {
//		Optional<ParkingEntity>op=repoparking.findById(parkingId);
//		if(op.isEmpty()) {
//			return"redirect;/listparking";
//		}else {
//			model.addAttribute("parking", op.get());
//			return"EditParking";
//		}
//	}
//	
//	@PostMapping("updateparking")
//	public String updateparking(ParkingEntity parking){
//		Optional<ParkingEntity> op = repoparking.findById(parking.getParkingId());
//		if(op.isPresent()) {
//			ParkingEntity dbparking=op.get();
//			dbparking.setAddress(parking.getAddress());
//			repoparking.save(dbparking);
//			
//		}return"redirect:/listparking";
//	}

	
		
	

}
