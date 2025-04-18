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


@Query(value = "select r.* ,u.first_name,u.last_name,u.contact_num,p.title,p.address from users u , parking p,reservation r where r.user_id = u.user_id and p.parking_id=r.parking_id and r.user_id=:userId ", nativeQuery = true)

List<Object[]> getAllByUserId(@org.springframework.data.repository.query.Param("userId") Integer userId);

int countByUserId(int userId);

@Query(value = "SELECT COUNT(*) FROM reservation WHERE parking_id = :parkingId AND vehicle_type = :vehicleType AND status = 'active'", nativeQuery = true)
int countActiveReservations(@Param("parkingId") int parkingId, @Param("vehicleType") String vehicleType);

@Query(value = "SELECT COUNT(*) FROM reservation WHERE CONCAT(date, ' ', end_time) < NOW() AND user_id = :userId", nativeQuery = true)
int countPastReservationsByUser(@Param("userId") Integer userId);


@Query(value = "SELECT COUNT(*) FROM reservation " +
        "WHERE user_id = :userId " +
        "AND date = CURDATE() " +
        "AND start_time <= CURTIME() " +
        "AND end_time >= CURTIME()", nativeQuery = true)
int countCurrentReservations(@Param("userId") Integer userId);


@Query(value="SELECT COUNT(*) FROM reservation WHERE user_id = :userId AND date < CURDATE()", nativeQuery = true)
int countPastReservations(@Param("userId") Integer userId);

	


}
