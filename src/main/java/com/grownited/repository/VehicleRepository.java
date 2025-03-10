package com.grownited.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import com.grownited.entity.VehicleEntity;

public interface VehicleRepository extends JpaRepository<VehicleEntity, Integer> {
	
	@Query(value = "select v.*,u.first_name,u.last_name,u.email,u.contact_num from vehicle v, users u where v.user_id  = u.user_id",nativeQuery = true)
	List<Object[]> getAll();

}
