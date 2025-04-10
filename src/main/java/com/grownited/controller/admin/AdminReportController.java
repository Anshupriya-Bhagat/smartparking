package com.grownited.controller.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.grownited.entity.ParkingEntity;
import com.grownited.entity.ReservationEntity;
import com.grownited.entity.UserEntity;
import com.grownited.entity.VehicleEntity;
import com.grownited.repository.ParkingRepository;
import com.grownited.repository.ReservationRepository;
import com.grownited.repository.UserRepository;
import com.grownited.repository.VehicleRepository;

@Controller
public class AdminReportController {
	
	@Autowired
	UserRepository repouser;
	
	@Autowired
	ParkingRepository repoparking;
	
	@Autowired
	ReservationRepository reporeservation;
	
	@Autowired
	VehicleRepository repovehicle;
	
	@GetMapping("adminreportuser")
	public String adminreportuser(Model model) {
		List<UserEntity> users =repouser.findByRole("USER");
		long totalUsers = users.size();
		model.addAttribute("userList", users);
		return"admindashboard/AdminReportUser";
	}
	
	@GetMapping("adminreportparkingowner")
	public String adminreportparkingowmer(Model model) {
		List<ParkingEntity>parking=repoparking.findAll();
		
		model.addAttribute("allparking", parking);
		return"admindashboard/AdminReportParkingOwner";
	}
	
	@GetMapping("adminreportreservation")
	public String adminreportreservation(Model model) {
		List<ReservationEntity>reservation=reporeservation.findAll();
		model.addAttribute("allreservation", reservation);
		return"admindashboard/AdminReportReservation";
	}
	
	@GetMapping("adminreportvehicle")
	public String adminreportvehicle(Model model) {
		List<VehicleEntity>vehicle=repovehicle.findAll();
		model.addAttribute("allvehicle", vehicle);
		return"admindashboard/AdminReportVehicle";
	}

}
