package com.grownited.controller;



import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


import com.grownited.entity.ReservationEntity;
import com.grownited.repository.ReservationRepository;

@Controller
public class ReservationController {
	
	@Autowired
	ReservationRepository reporeservation;
	@GetMapping(value= {"/","reservation"})
	public String reservation() {
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
		List<ReservationEntity> reservationList = reporeservation.findAll();	
		model.addAttribute("reservationList", reservationList);
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
