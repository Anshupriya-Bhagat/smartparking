package com.grownited.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.grownited.entity.VehicleEntity;

public interface VehicleRepository extends JpaRepository<VehicleEntity, Integer> {

}
