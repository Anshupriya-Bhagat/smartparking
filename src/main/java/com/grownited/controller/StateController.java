package com.grownited.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.grownited.entity.CityEntity;
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
    
    	repoState.save(state);
        return"redirect:/liststate";	
    }
    
    @GetMapping("liststate")
	public String liststate(Model model) {
		
		
		List<StateEntity> allstate = repoState.findAll();

		model.addAttribute("allstate", repoState.findAll());
		
		return("ListState");
	}
	
	@GetMapping("viewstate")
	public String viewstate(Integer stateID, Model model) {
		List<Object[]>op=repoState.getBystateId(stateID);
		model.addAttribute("state", op);
		return"ViewState";
	}
	
	@GetMapping("deletestate")
	public String deletestate(Integer stateID) {
		repoState.deleteById(stateID);
		return"redirect:/liststate";
	}
	
	@GetMapping("editstate")
	public String editstate(Integer stateID,Model model) {
		
		Optional<StateEntity>op=repoState.findById(stateID);
		
		if(op.isEmpty()) {
			return"redirect:/liststate";
		}else {
			model.addAttribute("state", op.get());
			return"EditState";
		}
	}
	
	@PostMapping("updatestate")
	public String updatecity(StateEntity state) {
		System.out.println(state.getStateID());
		Optional<StateEntity>op=repoState.findById(state.getStateID());
		if(op.isPresent()) {
			StateEntity dbstate=op.get();
			
			dbstate.setStateName(state.getStateName());
			repoState.save(dbstate);
		}
		return"redirect:/liststate";
	}
	
	
	
	
	
}
