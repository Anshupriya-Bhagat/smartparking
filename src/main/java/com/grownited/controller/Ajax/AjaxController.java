package com.grownited.controller.Ajax;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.grownited.repository.LocationRepository;
import com.grownited.entity.LocationEntity;


@RestController
public class AjaxController {
	

	@Autowired
	LocationRepository repolocation;
	
	
	  @GetMapping("/getAllLocationBycityId/{cityId}") public List<LocationEntity>
	  getAllLocationByCityId(@PathVariable Integer cityId) {
	  System.out.println(cityId);
	  
	  List<LocationEntity>alllocations=repolocation.findByCityId(cityId);
	  return alllocations; }
	 

}
