package com.grownited.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.grownited.entity.UserEntity;
import com.grownited.repository.UserRepository;


@Controller
public class SessionController {
	
	@Autowired
	UserRepository repouser; 
	@GetMapping(value={"/","signup"})
	public String signup() {
		return("Signup");
	}
	
	@GetMapping("login")
	public String login(UserEntity userEntity) {
		System.out.println(userEntity.getEmail());
		System.out.println(userEntity.getPassword());
		return("Login");
	}
	
	
	@PostMapping("saveuser")
	public String saveuser(UserEntity userEntity) {
		repouser.save(userEntity);
		return ("Login");
	}
	
	
	@GetMapping("listuser")
	public String listMember(Model model) {
		List<UserEntity> userList = repouser.findAll();
		model.addAttribute("userList", userList);
		return "ListUser";
	}
	
	@GetMapping("forgotpassword")
	public String forgotpassword() {
		return ("ForgotPassword");
	}
	
	@PostMapping("sendotp")
	public String sendotp() {
		return ("UpdatePassword");
	}
	
	@PostMapping("updatepassword")
	public String updatepassword() {
		return ("Login");
	}

}
