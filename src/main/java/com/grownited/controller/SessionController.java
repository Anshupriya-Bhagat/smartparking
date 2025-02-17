package com.grownited.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
		System.out.println(userEntity.getFirstName());
		System.out.println(userEntity.getLastName());
		System.out.println(userEntity.getGender());
		System.out.println(userEntity.getPassword());
		System.out.println(userEntity.getContactnum());
		repouser.save(userEntity);
		return ("Login");
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
