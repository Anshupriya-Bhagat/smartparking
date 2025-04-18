package com.grownited.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.grownited.entity.UserEntity;
import com.grownited.entity.VehicleEntity;

public interface VehicleRepository extends JpaRepository<VehicleEntity, Integer> {
	
	@Query(value = "select v.*,u.first_name,u.last_name,u.email,u.contact_num from vehicle v, users u where v.user_id  = u.user_id",nativeQuery = true)
	List<Object[]> getAll();
	
	@Query(value = "select v.*,u.first_name,u.last_name,u.email,u.contact_num from vehicle v, users u where v.user_id  = u.user_id and v.vehicle_id=:vehicleId",nativeQuery = true)
	List<Object[]> getByVehicleId(Integer vehicleId);
//
//	List<VehicleEntity> findByUserId(Integer userId);
//
	@Query(value = "select v.*,u.first_name,u.last_name,u.email,u.contact_num from vehicle v, users u where v.user_id  = u.user_id and v.user_id=:userId",nativeQuery = true)

	List<Object[]> getAllByUserId(@org.springframework.data.repository.query.Param("userId") Integer userId);

	int countByUserId(int userId);


//	List<VehicleEntity> findByUserId(@org.springframework.data.repository.query.Param("userId") Integer userId);

	

	


}
