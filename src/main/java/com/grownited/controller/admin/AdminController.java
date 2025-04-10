package com.grownited.controller.admin;


import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.grownited.Service.DateUtil;
import com.grownited.entity.ParkingEntity;
import com.grownited.entity.ReservationEntity;
import com.grownited.entity.UserEntity;
import com.grownited.repository.CityRepository;
import com.grownited.repository.LocationRepository;
import com.grownited.repository.ParkingRepository;
import com.grownited.repository.ReservationRepository;
import com.grownited.repository.StateRepository;
import com.grownited.repository.UserRepository;
import com.grownited.repository.VehicleRepository;

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
	
	@GetMapping("adminviewusers")
	public String adminviewusers(Integer userId,Model model) {
		List<Object[]>op=repouser.getByuserId(userId);
		model.addAttribute("user", op);
		return"admindashboard/AdminViewUsers";
	}
	
	@GetMapping("admindeleteusers")
	public String admindeleteuser(Integer userId) {
		repouser.deleteById(userId);
		return"redirect:/adminlistuser";
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
//    @GetMapping("adminviewvehicle")
//	public String adminviewvehicle(Integer vehicleId, Model model) {
//		List<Object[]> op = repovehicle.getByVehicleId(vehicleId);
//		model.addAttribute("vehicle", op);
//		return"admindashboard/AdminViewVehicle";
//	}
    
//    @GetMapping("adminlistlocation")
//    public String adminlistlocation(Model model){
//  	 List<Object[]> alllocation = repolocation.getAll();
//       model.addAttribute("alllocation",alllocation );
//  	return"admindashboard/AdminListLocation";
// }
//    
//    @GetMapping("admindeletelocation")
//	public String deletelocation(Integer locationId) {
//		repolocation.deleteById(locationId);
//		return"redirect:/adminlistlocation";
//	}
    
//    @GetMapping("adminlistlocation")
//    public String adminlistlocation(Model model){
//    	 List<Object[]> alllocation = repolocation.getAll();
//         model.addAttribute("alllocation",alllocation );
//    	return"admindashboard/AdminListLocation";
//    }
	
//    @GetMapping("adminlistcity")
//    public String adminlistcity(){
//    	return"admindashboard/AdminListcity";
//    }
    
//    @GetMapping("adminliststate")
//    public String adminliststate(){
//    	return"admindashboard/AdminListState";
//    }
	
}
