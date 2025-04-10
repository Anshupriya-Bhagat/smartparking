package com.grownited.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.grownited.entity.UserEntity;
@Repository
public interface UserRepository extends JpaRepository<UserEntity, Integer>{
	Optional<UserEntity> findByEmail(String email);
	
	
	//List<UserEntity>getByuserId(Integer userId);
	
	@Query(value="select * from users where user_id=:userId" ,nativeQuery=true)
	List<Object[]>getByuserId(Integer userId);
	

	
	List<UserEntity> findByRole(String role);
	
	

}
