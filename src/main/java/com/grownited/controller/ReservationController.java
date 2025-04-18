package com.grownited.controller;



import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.grownited.entity.CityEntity;
import com.grownited.entity.LocationEntity;
import com.grownited.entity.ParkingEntity;
import com.grownited.entity.ReservationEntity;
import com.grownited.entity.UserEntity;
import com.grownited.entity.VehicleEntity;
import com.grownited.repository.CityRepository;
import com.grownited.repository.LocationRepository;
import com.grownited.repository.ParkingRepository;
import com.grownited.repository.ReservationRepository;
import com.grownited.repository.UserRepository;
import com.grownited.repository.VehicleRepository;

import jakarta.servlet.http.HttpSession;

@Controller
public class ReservationController {
	
	@Autowired
	ReservationRepository reporeservation;
	
	@Autowired
	UserRepository repouser;
	
	
	@Autowired
	VehicleRepository repovehicle;
	
	@Autowired
	ParkingRepository repoparking;
	
	@Autowired
	LocationRepository repolocation;
	
	@Autowired
	CityRepository repocity;
	
	@GetMapping(value= {"/","reservation"})
	public String reservation(Model model, Integer parkingId,HttpSession session) {
		
		UserEntity user = (UserEntity) session.getAttribute("user");
		
		model.addAttribute("reservation", new ReservationEntity());
	    model.addAttribute("parkingId", parkingId);
		
		List<UserEntity> allusers  = repouser.findAll();
		 model.addAttribute("allusers", allusers);
		 
		 List<VehicleEntity> allvehicles  = repovehicle.findAll();
		 model.addAttribute("allvehicles", allvehicles);
		 
		 List<ParkingEntity> allparkings  = repoparking.findAll();
		 model.addAttribute("allparkings", allparkings);
		 
		 List<CityEntity> allcity  = repocity.findAll();
		 model.addAttribute("allcity", allcity);
		 
		 List<LocationEntity>alllocation=repolocation.findAll();
	    model.addAttribute("alllocation", alllocation);
	    
	    Optional<ParkingEntity> op=repoparking.findById(parkingId);
    	model.addAttribute("parking", op.get());
    	
    	List<Object[]> vehicleList = repovehicle.getAllByUserId(user.getUserId());    
	    model.addAttribute("vehicleList", vehicleList);
	   
		return ("Reservation");
	}

	
	@PostMapping("savereservation")
	public String savereservation(ReservationEntity reservation, HttpSession session) {
		UserEntity user = (UserEntity) session.getAttribute("user");
		Integer userId = user.getUserId();
        reservation.setUserId(userId);
		reservation.setPaymentStatus("Completed");
		
		
		
		
		reporeservation.save(reservation);
		return ("Checkout");
	}
	
	@GetMapping("/listreservation")
	public String listreservation(HttpSession session, Model model) {
	    UserEntity user = (UserEntity) session.getAttribute("user");

	    if (user == null) {
	        return "redirect:/login";  
	    }
        
	    List<Object[]> reservationList = reporeservation.getAllByUserId(user.getUserId());    
	    model.addAttribute("reservationList", reservationList);

	    return ("ListReservation");
	}
	
	
	  @GetMapping("viewreservation") 
	  public String viewreservation(Integer reservationId,Model model) {
		  List<Object[]> op =reporeservation.getByReservationId(reservationId);
	  model.addAttribute("reservation", op);
	  return"ViewReservation"; 
	  }
	 
	
	@GetMapping("deletereservation")
	public String deletereservation(Integer reservationId) {
		reporeservation.deleteById(reservationId);
		return"redirect:/listreservation";
	}
	
	@GetMapping("editreservation")
	public String editreservation(Integer reservationId,Model model) {
		Optional<ReservationEntity> op = reporeservation.findById(reservationId);
		if(!op.isPresent()) {
			return"redirect:/listreservation";
		}else {
			model.addAttribute("reservation", op.get());
			return"EditReservation";
		}
	}
	
	
	@PostMapping("updatereservation")
	public String updatereservation(ReservationEntity reservation) {
		
		Optional<ReservationEntity>op=reporeservation.findById(reservation.getReservationId());
		if(op.isPresent()) {
			ReservationEntity dbreservation=op.get();
			dbreservation.setDate(reservation.getDate());
			dbreservation.setEndTime(reservation.getEndTime());
			dbreservation.setStartTime(reservation.getStartTime());
			reporeservation.save(dbreservation);
		}return"redirect:/listreservation";
		
	}
	
	
	
	
	
	
	
	

}
