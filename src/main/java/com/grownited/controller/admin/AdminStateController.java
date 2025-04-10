package com.grownited.controller.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


import com.grownited.entity.StateEntity;
import com.grownited.repository.StateRepository;

@Controller
public class AdminStateController {
	
	@Autowired
	StateRepository repoState;
	
	@GetMapping("adminaddstate")
	public String adminaddlocation() {
		return"admindashboard/AdminAddLocation";
	}
	
	@PostMapping("adminsavestate")
    public String adminsavestate(StateEntity state) {
    repoState.save(state);
        return"redirect:/adminliststate";	
    }
    
    @GetMapping("adminliststate")
	public String adminliststate(Model model) {
		
		List<StateEntity> allstate = repoState.findAll();
        model.addAttribute("allstate", allstate);
		
		return("admindashboard/AdminListState");
	}
    
    @GetMapping("adminviewstate")
  	public String adminviewstate(Integer stateID, Model model) {
  		List<Object[]> op = repoState.getBystateId(stateID);
  		model.addAttribute("state", op);
  		return"admindashboard/AdminViewState";
  	}
    
	@GetMapping("admindeletestate")
	public String admindeletestate(Integer stateID) {
		repoState.deleteById(stateID);
		return "redirect:/adminliststate";
	}

}
