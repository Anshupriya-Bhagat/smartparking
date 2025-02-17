package com.grownited.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
		reporeservation.save(reservation);
		return ("Reservation");
	}

}
