package com.grownited.repository;


import java.sql.Date;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.grownited.entity.ReservationEntity;
import com.grownited.entity.UserEntity;
import com.grownited.entity.VehicleEntity;

public interface ReservationRepository extends JpaRepository<ReservationEntity, Integer>{

	@Query(value = "select r.* ,u.first_name,u.last_name,u.contact_num,p.title,p.address from users u , parking p,reservation r where r.user_id = u.user_id and p.parking_id=r.parking_id ", nativeQuery = true)
	List<Object[]> getAll();

	@Query(value = "SELECT r.*, u.first_name, u.last_name, u.contact_num, p.title, p.address " +
            "FROM users u, parking p, reservation r " +
            "WHERE r.user_id = u.user_id " +
            "AND r.parking_id = p.parking_id " +
            "AND r.reservation_id = :reservationId", nativeQuery = true)
List<Object[]> getByReservationId(@Param("reservationId") Integer reservationId);



	









	





}
