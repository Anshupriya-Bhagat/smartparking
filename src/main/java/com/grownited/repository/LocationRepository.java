package com.grownited.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.grownited.entity.LocationEntity;

@Repository
public interface LocationRepository extends JpaRepository<LocationEntity, Integer> {
	@Query(value = "SELECT * FROM location WHERE location_id=:locationId", nativeQuery = true)
	List<Object[]> getByLocationId(Integer locationId);

//	@Query(value="SELECT * FROM location WHERE city_id = :cityId", nativeQuery = true)
//	List<Object[]> getAll();
	
	@Query(value="SELECT l.*,c.city_name FROM location l,cities c WHERE l.city_id=c.city_id", nativeQuery = true)
	List<Object[]> getAll();

	
   @Query(value = "SELECT * FROM location WHERE city_id = :cityId", nativeQuery = true)
	List<LocationEntity> findByCityId( Integer cityId);
   
   @Query("SELECT COUNT(l) FROM LocationEntity l")
   long countTotalLocations();


	

}
