package com.grownited.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import com.grownited.entity.ParkingEntity;
import com.grownited.entity.VehicleEntity;


@Repository
public interface ParkingRepository extends JpaRepository<ParkingEntity, Integer>{
	
	@Query(value="select p.*,u.first_name, u.last_name, u.contact_num,l.loction_name from parking p,users u,location l where p.user_id=u.user_id and p.location_id = l.location_id",nativeQuery = true)
	List<Object[]> getAll();

	@Query(value="select p.*,u.first_name, u.last_name, u.contact_num,l.loction_name from parking p,users u,location l where p.user_id=u.user_id and p.location_id = l.location_id and p.parking_id =:parkingId",nativeQuery = true)
	List<Object[]> getByParkingId(Integer parkingId);
	
	@Query(value = "SELECT DISTINCT * FROM parking WHERE location_id = :locationId", nativeQuery = true)
	List<Object[]> findUniqueByLocation(@Param("locationId") int locationId);
	

	}
