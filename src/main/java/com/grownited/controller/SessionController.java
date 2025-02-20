package com.grownited.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.grownited.Service.MailService;
import com.grownited.entity.UserEntity;
import com.grownited.repository.UserRepository;


@Controller
public class SessionController {
	
	@Autowired
	UserRepository repouser; 
	
	
	@Autowired
	MailService serviceMail;
	
	
	@Autowired
	PasswordEncoder encoder;
	
	
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
	
	@PostMapping("authenticate")
	public String authenticate(String email, String password,Model model) {
		System.out.println(email);
		System.out.println(password);

	
		Optional<UserEntity> op = repouser.findByEmail(email);
		if (op.isPresent()) {
			// true
			
			UserEntity dbUser = op.get();
			if (encoder.matches(password, dbUser.getPassword())) {
				return "redirect:/home";
			}
		}
		model.addAttribute("error","Invalid Credentials");
		return "Login";
	}
	
	
	@PostMapping("saveuser")
	public String saveuser(UserEntity userEntity) {
		
		serviceMail.sendWelcomeMail(userEntity.getEmail(), userEntity.getFirstName());
		userEntity.setRole("USER");
		String encPassword = encoder.encode(userEntity.getPassword());
		userEntity.setPassword(encPassword);
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
	
	@GetMapping("viewusers")
	public String viewuser(Integer userId, Model model) {
		System.out.println("id ==>" +userId);
		 Optional<UserEntity> op = repouser.findById(userId);
		
		if(op.isEmpty()) {
			//data not found
		}
		else {
			UserEntity user = op.get();
			model.addAttribute("user",user);
			}
		return "ViewUsers";
	}
	
	@GetMapping("deleteuser")
	public String deleteuser(Integer userId) {
		repouser.deleteById(userId);
		return "redirect:/listuser";
	}
	
	
	
}	


