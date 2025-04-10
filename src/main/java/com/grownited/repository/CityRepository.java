package com.grownited.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import com.grownited.entity.CityEntity;

@Repository
public interface CityRepository extends JpaRepository<CityEntity, Integer> {
	@Query(value = "select * from cities where city_id=:cityId",nativeQuery = true)

	List<Object[]>getBycityId( Integer cityId);
	
	@Query(value = "select * from cities",nativeQuery = true)
	List<Object[]> getAll();
	
	
	

}
