package com.grownited.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.grownited.Service.PaymentService;
import com.grownited.entity.UserEntity;

import jakarta.servlet.http.HttpSession;

@Controller
public class PaymentController {
	
	@Autowired
	PaymentService paymentservice;
	
	@GetMapping("makepayment")
	public String makepayment(Model model) {
		model.addAttribute("amount", 500);
		return"Checkout";
	}
	

	@PostMapping("pay")
	public String pay(String ccNum, String expDate, HttpSession session) {
		UserEntity user = (UserEntity) session.getAttribute("user");


		 paymentservice.chargeCreditCard("	8YtDU97p6", "4zgpt88Nf4729XME", 500.0 , ccNum, expDate, user.getEmail());
		

		return "redirect:/home";
	}

}
