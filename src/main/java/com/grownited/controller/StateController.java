package com.grownited.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


import com.grownited.entity.StateEntity;
import com.grownited.repository.StateRepository;

@Controller
public class StateController {
	
	@Autowired
	StateRepository repoState;
	
    @GetMapping(value ={"/","newstate"})
    public String newstate() {
    	return"NewState";
    }
    @PostMapping("savestate")
    public String savestate(StateEntity state) {
    
    	System.out.println(state.getStateName());
    	repoState.save(state);
        return"NewState";	
    }
    
    @GetMapping("liststate")
	public String liststate(Model model) {
		
		
		List<StateEntity> allstate = repoState.findAll();

		model.addAttribute("allstate", repoState.findAll());
		
		return("ListState");
	}
	
	@GetMapping("viewstate")
	public String viewstate(Integer stateID, Model model) {
		System.out.println("id ==>" +stateID);
		 Optional<StateEntity> op= repoState.findById(stateID);
		 if(op.isEmpty()) {
			 //data not found
		 }
		 else {
			 StateEntity state = op.get();
			 model.addAttribute("state", state);
			 }
		
		return"ViewState";
	}
	
	@GetMapping("deletestate")
	public String deletestate(Integer stateID) {
		repoState.deleteById(stateID);
		return"redirect:/liststate";
	}
}
