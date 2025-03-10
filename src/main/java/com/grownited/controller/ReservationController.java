package com.grownited.controller;



import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


import com.grownited.entity.ParkingEntity;
import com.grownited.entity.ParkingSlotEntity;
import com.grownited.entity.ReservationEntity;
import com.grownited.entity.UserEntity;
import com.grownited.entity.VehicleEntity;
import com.grownited.repository.ParkingRepository;
import com.grownited.repository.ParkingSlotRepository;
import com.grownited.repository.ReservationRepository;
import com.grownited.repository.UserRepository;
import com.grownited.repository.VehicleRepository;

@Controller
public class ReservationController {
	
	@Autowired
	ReservationRepository reporeservation;
	
	@Autowired
	UserRepository repouser;
	
	@Autowired
	ParkingSlotRepository repoparkingslot;
	
	@Autowired
	VehicleRepository repovehicle;
	
	@Autowired
	ParkingRepository repoparking;
	
	@GetMapping(value= {"/","reservation"})
	public String reservation(Model model) {
		
		List<UserEntity> allusers  = repouser.findAll();
		 model.addAttribute("allusers", allusers);
		 
		 List<ParkingSlotEntity> allparkingslot  = repoparkingslot.findAll();
		 model.addAttribute("allparkingslot", allparkingslot);
		 
		 List<VehicleEntity> allvehicles  = repovehicle.findAll();
		 model.addAttribute("allvehicles", allvehicles);
		 
		 List<ParkingEntity> allparkings  = repoparking.findAll();
		 model.addAttribute("allparkings", allparkings);
		
		return ("Reservation");
	}
	
	@PostMapping("savereservation")
	public String savereservation(ReservationEntity reservation) {
		System.out.println(reservation.getPaymentStatus());
		System.out.println(reservation.getAmountPaid());
		System.out.println(reservation.getSecurityAmountPaid());
		reservation.setPaymentStatus("Completed");
		reporeservation.save(reservation);
		return ("redirect:/listreservation");
	}
	
	@GetMapping("listreservation")
	public String listreservation(Model model) {
		
		List<Object[]> allreservation = reporeservation.getAll();

		model.addAttribute("allreservation", reporeservation.getAll());
		
		return ("ListReservation");
	}
	
	@GetMapping("viewreservation")
	public String viewreservation(Integer reservationId,Model model) {
		System.out.println("id==>" +reservationId);
		Optional<ReservationEntity> op = reporeservation.findById(reservationId);
		if(op.isEmpty()) {
			
		}
		else {
			ReservationEntity reservation = op.get();
			model.addAttribute("reservation", reservation);
			}
		return"ViewReservation";
	}
	
	@GetMapping("deletereservation")
	public String deletereservation(Integer reservationId) {
		reporeservation.deleteById(reservationId);
		return"redirect:/listreservation";
	}
	
	
	
	
	
	
	
	

}
