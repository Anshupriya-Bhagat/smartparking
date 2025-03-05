package com.grownited.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.grownited.Dto.Parkingdto;
import com.grownited.entity.ParkingEntity;


@Repository
public interface ParkingRepository extends JpaRepository<ParkingEntity, Integer>{
	
	//@Query(value = "select p.*,u.first_name,u.last_name,u.gender,u.email,u.contact_num from parking p,users u where u.user_id = p.user_id",nativeQuery = true)
	@Query(value="select parking_id, p.title, p.address, p.user_id, p.total_capacity_two_wheeler,p.total_capacity_four_wheeler , p.other_information, p.active,p.hourly_charge_for_four_wheeler, p. hourly_charge_for_two_wheeler ,p.longitude, p.latitude, p.parking_type,u.first_name, u.last_name, u.email, u.gender, u.contact_num from parking p,users u where p.user_id=u.user_id",nativeQuery = true)
	List<Parkingdto> getAll();

}
