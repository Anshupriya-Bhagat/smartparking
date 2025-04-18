/*
 * package com.grownited.repository;
 * 
 * import java.util.List;
 * 
 * import org.springframework.data.jpa.repository.JpaRepository; import
 * org.springframework.data.jpa.repository.Query;
 * 
 * import com.grownited.entity.PaymentEntity;
 * 
 * public interface PaymentRepository extends JpaRepository<PaymentEntity,
 * Integer>{
 * 
 * @Query(value =
 * "select p.*,r.reservation_id from payment p,reservation r where r.reservation_id=p.reservation_id"
 * , nativeQuery = true) List<Object[]> getAll();
 * 
 * }
 */
