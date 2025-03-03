package com.grownited.controller.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.grownited.entity.UserEntity;
import com.grownited.repository.UserRepository;

@Controller
public class AdminController {
 @Autowired
 UserRepository repouser;
	
	@GetMapping("admindashboard")
	public String admin(Model model) {
		List<UserEntity> userList = repouser.findAll(); // Fetch user data
        model.addAttribute("userList", userList); 
		return("AdminDashboard");
	}
	
	
}
