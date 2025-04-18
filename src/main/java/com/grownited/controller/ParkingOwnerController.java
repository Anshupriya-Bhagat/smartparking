package com.grownited.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.grownited.entity.CityEntity;
import com.grownited.entity.LocationEntity;
import com.grownited.entity.ParkingEntity;
import com.grownited.entity.UserEntity;
import com.grownited.repository.CityRepository;
import com.grownited.repository.LocationRepository;
import com.grownited.repository.ParkingRepository;
import com.grownited.repository.ReservationRepository;
import com.grownited.repository.UserRepository;

import jakarta.servlet.http.HttpSession;



@Controller
public class ParkingOwnerController {
	
	@Autowired
	ParkingRepository repoparking;
	
	@Autowired
	LocationRepository repolocation;
	
	@Autowired
	CityRepository repocity;
	
	@Autowired
	ReservationRepository reporeservation;
	
	@Autowired
	UserRepository repouser;
    
    @GetMapping("parkingowner")
    public String parkingowner(Model model,Integer locationId) {
    	
    	Long totalparkings=repoparking.count();
    	model.addAttribute("totalparkings", totalparkings);
    	
    	Long totalreservations=reporeservation.count();
    	model.addAttribute("totalreservations", totalreservations);
    	
    	Long totalLocations = repolocation.countTotalLocations();
        model.addAttribute("totalLocations", totalLocations);
        
        
    	return "parkingOwner/ParkingOwner"; 
    }
    
    @GetMapping("owneraddparking")
    public String owneraddparking(Model model) {
    	List<LocationEntity>alllocation=repolocation.findAll();
    	model.addAttribute("alllocation", alllocation);
    	
    	List<CityEntity>allcity=repocity.findAll();
    	model.addAttribute("allcity", allcity);
     return"parkingOwner/OwnerAddParking";
    }
    

	@PostMapping("saveparking")
	public String saveparking(ParkingEntity parking, HttpSession session) {
		UserEntity user =(UserEntity) session.getAttribute("user");
		Integer userId=user.getUserId();
		parking.setUserId(userId);
		parking.setActive("Active");
		parking.setHourlyChargeForFourWheeler(700);
		parking.setHourlyChargeForTwoWheeler(500);
		repoparking.save(parking);
		return "redirect:/listparkingowner";
	}
    
    @GetMapping("listparkingowner")
    public String listparkingowner(Model model) {
    	List<Object[]>allparking=repoparking.getAll();
    	model.addAttribute("allparking", allparking);
    	return"parkingOwner/ListParkingOwner";
    }
    
    @GetMapping("ownerviewparking")
	public String ownerviewparking(Integer parkingId,Model model) {
		List<Object[]> op = repoparking.getByParkingId(parkingId);
		model.addAttribute("parking", op);
		return"parkingOwner/OwnerViewParking";
	}
	
	@GetMapping("deleteparking")
	public String deleteuser(Integer parkingId) {
		repoparking.deleteById(parkingId);
		return "redirect:/listparkingowner";
	}
	
	@GetMapping("ownereditparking")
	public String ownereditparking(Integer parkingId,Model model) {
		Optional<ParkingEntity>op=repoparking.findById(parkingId);
		if(op.isEmpty()) {
			return"redirect:/listparkingowner";
		}else {
			model.addAttribute("parking", op.get());
			return"parkingOwner/OwnerEditParking";
		}
	}
	
	@PostMapping("updateparking")
	public String updateparking(ParkingEntity parking){
		Optional<ParkingEntity> op = repoparking.findById(parking.getParkingId());
		if(op.isPresent()) {
			ParkingEntity dbparking=op.get();
			dbparking.setAddress(parking.getAddress());
			dbparking.setTotalCapacityFourWheeler(parking.getTotalCapacityFourWheeler());
			dbparking.setTotalCapacityTwoWheeler(parking.getTotalCapacityTwoWheeler());
			repoparking.save(dbparking);
			
		}return"redirect:/listparkingowner";
	}
	
	@GetMapping("/owneredit")
	public String editUser(HttpSession session, Model model) {
		UserEntity user = (UserEntity) session.getAttribute("user");
	    model.addAttribute("user", user);
	    return "parkingOwner/OwnerEdit";
	}
	
	@PostMapping("ownerupdate")
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

