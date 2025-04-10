package com.grownited.repository;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.grownited.entity.StateEntity;

public interface StateRepository extends JpaRepository<StateEntity, Integer> {
	
  @Query(value="select * from state where stateid=:stateId",nativeQuery=true)
  List<Object[]> getBystateId(Integer stateId);
	

}
