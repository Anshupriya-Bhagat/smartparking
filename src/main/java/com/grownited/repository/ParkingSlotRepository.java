package com.grownited.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.grownited.entity.ParkingSlotEntity;

public interface ParkingSlotRepository extends JpaRepository<ParkingSlotEntity, Integer> {

}
