package com.grownited.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.grownited.Dto.Citydto;
import com.grownited.entity.CityEntity;

@Repository
public interface CityRepository extends JpaRepository<CityEntity, Integer> {
	@Query(value = "select c.*,s.state_name from state s,cities c where s.stateid = c.stateid",nativeQuery = true)
	List<Citydto> getAll();
}
