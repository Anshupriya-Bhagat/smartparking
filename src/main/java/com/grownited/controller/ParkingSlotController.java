package com.grownited.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


import com.grownited.entity.ParkingSlotEntity;
import com.grownited.repository.ParkingSlotRepository;

@Controller
public class ParkingSlotController {
	
	@Autowired
	ParkingSlotRepository repoparkingslot;
	@GetMapping(value= {"/","parkingslot"})
	public String parkingslot() {
		return("ParkingSlot");
	}
	
	@PostMapping("saveparkingslot")
	public String saveparkingslot(ParkingSlotEntity parkingslot) {
		System.out.println(parkingslot.getFloor());
		System.out.println(parkingslot.getSuvSupported());
		System.out.println(parkingslot.getMinimumParkingMinutes());
		System.out.println(parkingslot.getParkingTag());
		parkingslot.setActive(true);
		repoparkingslot.save(parkingslot);
		return("ParkingSlot");
	}

}
