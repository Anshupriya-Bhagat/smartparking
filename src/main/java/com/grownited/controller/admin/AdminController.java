package com.grownited.controller.admin;


import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.hibernate.dialect.identity.DB2390IdentityColumnSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.grownited.Service.DateUtil;
import com.grownited.entity.ParkingEntity;
import com.grownited.entity.ReservationEntity;
import com.grownited.entity.UserEntity;
import com.grownited.entity.VehicleEntity;
import com.grownited.repository.CityRepository;
import com.grownited.repository.LocationRepository;
import com.grownited.repository.ParkingRepository;
import com.grownited.repository.ReservationRepository;
import com.grownited.repository.StateRepository;
import com.grownited.repository.UserRepository;
import com.grownited.repository.VehicleRepository;

import jakarta.servlet.http.HttpSession;

@Controller
public class AdminController {
 @Autowired
 UserRepository repouser;
 
 @Autowired
 ParkingRepository repoparking;
 
 @Autowired
 ReservationRepository reporeservation;
 
 @Autowired
 VehicleRepository repovehicle;
 
 @Autowired
 LocationRepository repolocation;
 
 @Autowired
 CityRepository repocity;
 
 @Autowired
 StateRepository repostate;
 
    @GetMapping(value={"adminlocation"}) 
	public String adminaddlocation() {
		return "admindashboard/AdminLocation";
	}
    
    @GetMapping(value={"admincity"}) 
	public String admincity() {
		return "admindashboard/AdminCity";
	}
    
    @GetMapping(value={"adminstate"}) 
	public String adminstate() {
		return "admindashboard/AdminState";
	}
 
    @GetMapping("admindashboard")
    public String admindashboard(Model model) {
    	Integer totalusers=repouser.findByRole("USER").size();
    	model.addAttribute("totalusers", totalusers);
    	
    	Long totalparkings=repoparking.count();
    	model.addAttribute("totalparkings", totalparkings);
    	
    	Long totalreservations=reporeservation.count();
    	model.addAttribute("totalreservations", totalreservations);
    	
          return "admindashboard/AdminDashboard";
    	}
    

	@GetMapping("adminlistuser")
	public String adminlistuser(Model model) {
		List<UserEntity> userList = repouser.findAll();
		model.addAttribute("userList", userList);
		return "admindashboard/AdminListUser";
	}
	
	@GetMapping("/adminviewuser")
	public String adminviewuser(Integer userId, Model model) {
		
		System.out.println("id ===> " + userId);
		
		List<Object[]> op = repouser.getByuserId(userId);
		
		if(op.isEmpty()) {
			//Data not found
		}else {
		 
			model.addAttribute("user", op);
		}
		
		return "admindashboard/AdminViewUser";
	}
	
	@GetMapping("admindeleteuser")
	public String admindeleteuser(Integer userId) {
		repouser.deleteById(userId);
		return"redirect:/adminlistuser";
	}
	
	

	@GetMapping("adminedituser")
	public String adminedituser(Integer userId,Model model) {
		Optional<UserEntity> op = repouser.findById(userId);
		if (!op.isPresent()) {
			return "redirect:/adminlistuser";
		} else {
			model.addAttribute("userList",op.get());
			return "admindashboard/AdminEditUser";

		}
	}
	
	@PostMapping("adminupdateuser")
	public String adminedituser(UserEntity user) {
		
		System.out.println(user.getUserId());

		Optional<UserEntity> op = repouser.findById(user.getUserId());
		
		if(op.isPresent())
		{
			UserEntity dbuser = op.get(); 
			dbuser.setRole(user.getRole());
			 
			
			repouser.save(dbuser);
		}
		return "redirect:/adminlistuser";
	}
	

	@GetMapping("adminlistparking")
    public String adminlistparking(Model model) {
    	List<UserEntity> userList = repouser.findAll(); 
        model.addAttribute("userList", userList);
        
        List<Object[]> allparking = repoparking.getAll();
		model.addAttribute("allparking",allparking);
    	return "admindashboard/AdminListParking";
    }
    
    @GetMapping("adminviewparking")
	public String adminviewparking(Integer parkingId, Model model) {
		List<Object[]> op = repoparking.getByParkingId(parkingId);
		model.addAttribute("parking", op);
		return"admindashboard/AdminViewParking";
	}
    
    @GetMapping("adminlistreservation")
    public String adminlistreservation(Model model) {
    	List<UserEntity> userList = repouser.findAll(); 
        model.addAttribute("userList", userList);
        
        List<Object[]> allreservation = reporeservation.getAll();
        model.addAttribute("allreservation",allreservation);
        return"admindashboard/AdminListReservation";
    }
    
    @GetMapping("adminviewreservation")
	public String adminviewreservation(Integer reservationId,Model model) {
		List<Object[]> op = reporeservation.getByReservationId(reservationId);
		model.addAttribute("reservation", op);
		return"admindashboard/AdminViewReservation";
	}
    
    
    @GetMapping("adminlistvehicle")
    public String adminlistvehicle(Model model) {
    	List<UserEntity> userList = repouser.findAll(); 
        model.addAttribute("userList", userList);
        
        List<Object[]> allvehicle = repovehicle.getAll();
        model.addAttribute("allvehicle",allvehicle );
    	return"admindashboard/AdminListVehicle";
    }
//    
    @GetMapping("adminviewvehicle")
	public String adminviewvehicle(Integer vehicleId, Model model) {
		List<Object[]> op = repovehicle.getByVehicleId(vehicleId);
		model.addAttribute("vehicle", op);
		return"admindashboard/AdminViewVehicle";
	}


    @GetMapping("/adminedit")
	public String editUser(HttpSession session, Model model) {
		UserEntity user = (UserEntity) session.getAttribute("user");
	    model.addAttribute("user", user);
	    return "admindashboard/AdminEdit";
	}
	
	@PostMapping("adminupdate")
	public String adminupdate(UserEntity user) {
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
