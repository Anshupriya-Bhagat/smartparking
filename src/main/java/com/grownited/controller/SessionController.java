package com.grownited.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.grownited.Service.MailService;
import com.grownited.entity.UserEntity;
import com.grownited.repository.UserRepository;

import jakarta.servlet.http.HttpSession;


@Controller
public class SessionController {
	
	@Autowired
	UserRepository repouser; 
	
	
	@Autowired
	MailService serviceMail;
	
	
	@Autowired
	PasswordEncoder encoder;
	
	@Autowired
	private Cloudinary cloudinary;
	
	
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
	public String authenticate(String email, String password,Model model,HttpSession session) {
		System.out.println(email);
		System.out.println(password);

	
		Optional<UserEntity> op = repouser.findByEmail(email);
		
		
		if (op.isPresent()) {
			
			
			UserEntity dbUser = op.get();
			boolean ans = encoder.matches(password, dbUser.getPassword());
			
			 if (ans==true) {
				session.setAttribute("user", dbUser);
				
				 if(dbUser.getRole().equals("ADMIN")) {
					 return("redirect:admindashboard");
				 }
				 else if(dbUser.getRole().equals("USER")) {
					 return "redirect:home";
				 }
				 else if(dbUser.getRole().equals("ParkingOwner")) {
					 return "redirect:/parkingowner";
				 }
				 else {
						model.addAttribute("error", "Please contact Admin with Error Code #0991");
						return "Login";
					}
				
			}
		}
		model.addAttribute("error","Invalid Credentials");
		return ("Login");
	}
	
	
	@PostMapping("saveuser")
	public String saveuser(UserEntity userEntity,MultipartFile profilePic,Model model) {
		
		System.out.println(profilePic.getOriginalFilename());
		
		if(profilePic.getOriginalFilename().endsWith(".jpg") ||profilePic.getOriginalFilename().endsWith(".png") || profilePic.getOriginalFilename().endsWith(".jpeg") ) {
			
			try {
				Map result = cloudinary.uploader().upload(profilePic.getBytes(), ObjectUtils.emptyMap());
				System.out.println(result);
				System.out.println(result.get("url"));
				userEntity.setProfilePicPath(result.get("url").toString());
			} catch (IOException e) {
				
				e.printStackTrace();
			}
			
		}else {
			
			model.addAttribute("error","Invalid file format! Please upload a JPG, JPEG, or PNG file");
			return "Signup";
		}
		
		
		
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
	public String sendotp(Model model, String email) {
		Optional<UserEntity> op = repouser.findByEmail(email);
		
		if(op.isEmpty()) {
			model.addAttribute("error","Email not found");
			return("ForgotPassword");
		}
		else {
			
			String otp = "";
			otp = (int) (Math.random() * 1000000) + "";

			UserEntity user = op.get();
			user.setOtp(otp);
			repouser.save(user);
			serviceMail.sendOtpForForgetPassword(email, user.getFirstName(), otp);
			return "UpdatePassword";
		}
		
		
	}
	
	@PostMapping("updatepassword")
	public String updatepassword(String email, String password, String otp,Model model) {
		
		Optional<UserEntity> op = repouser.findByEmail(email);
		if (op.isEmpty()) {
			model.addAttribute("error", "Invalid Data");
			return "UpdatePassword";
		} else {
			UserEntity user = op.get();
			if (user.getOtp().equals(otp)) {
				String encPwd = encoder.encode(password);
				user.setPassword(encPwd);
				user.setOtp("");
				repouser.save(user);// update
			} else {

				model.addAttribute("error", "Invalid Data");
				return "UpdatePassword";
			}
		}
		model.addAttribute("msg","Password updated");
		return ("Login");
	}
	
	@GetMapping("viewusers")
	public String viewuser(Integer userId, Model model) {
		List<Object[]> op = repouser.getByuserId(userId);
		model.addAttribute("user", op);
		return "ViewUsers";
	}
	
	@GetMapping("deleteuser")
	public String deleteuser(Integer userId) {
		repouser.deleteById(userId);
		return "redirect:/listuser";
	}
	
	@GetMapping("logout")
	public String logout() {
		return "redirect:/login";
	}
	
	/*
	 * @GetMapping("edituser") public String edituser(Integer userId ,Model model) {
	 * Optional<UserEntity>op=repouser.findById(userId); if(op.isEmpty()) {
	 * return"redirect:/listuser"; }else { model.addAttribute("user", op.get());
	 * return"EditUser"; }
	 * 
	 * }
	 */
	
	@PostMapping("updateuser")
	public String updateuser(UserEntity user) {
		System.out.println(user.getUserId());
		
		Optional<UserEntity>op=repouser.findById(user.getUserId());
		
		if(op.isPresent()) {
			UserEntity dbuser=op.get();
			dbuser.setFirstName(user.getFirstName());
			repouser.save(dbuser);
		}return"redirect:/listuser";
	}
	
	
	
}	


