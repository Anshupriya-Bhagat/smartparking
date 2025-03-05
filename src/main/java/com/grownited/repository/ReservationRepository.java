package com.grownited.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import com.grownited.Dto.Reservationdto;
import com.grownited.entity.ReservationEntity;

public interface ReservationRepository extends JpaRepository<ReservationEntity, Integer>{
	
	@Query(value = "select r.*,u.first_name,v.registration_num,p.title,ps.floor from users u, vehicle v, parking p, reservation r,parkingslot ps where r.user_id=u.user_id AND r.vehicle_id=v.vehicle_id AND r.parking_id=p.parking_id AND r.parking_slot_id=ps.parking_slot_id",nativeQuery = true)
	List<Reservationdto> getAll();

}
