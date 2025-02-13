package com.grownited.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.grownited.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Integer>{

}
