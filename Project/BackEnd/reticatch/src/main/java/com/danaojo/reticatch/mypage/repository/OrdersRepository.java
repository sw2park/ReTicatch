package com.danaojo.reticatch.mypage.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.danaojo.reticatch.entity.Orders;

public interface OrdersRepository extends JpaRepository<Orders, Long> {
	@Query(value = "SELECT COUNT(*) FROM orders o WHERE seq_user_id = :seq_user_id", nativeQuery = true)
	int findByOrderCount(Long seq_user_id);

	@Query(value = "SELECT * FROM orders o WHERE :mode BETWEEN STR_TO_DATE(:prev_date, '%Y-%m-%d') AND STR_TO_DATE(:next_date, '%Y-%m-%d') AND o.seq_user_id = :user_seq", nativeQuery = true)
	List<Orders> getOrderDto(@Param("user_seq") Long user_seq, 
	                         @Param("mode") String mode, 
	                         @Param("prev_date") String prev_date, 
	                         @Param("next_date") String next_date);
	
//	@Query(value = "SELECT * FROM orders o WHERE :mode BETWEEN :prev_date AND :next_date AND o.seq_user_id = :user_seq", nativeQuery = true)
//	List<Orders> getOrderDto(@Param("user_seq") Long user_seq, @Param("mode") String mode, @Param("prev_date") String prev_date, @Param("next_date") String next_date);
}
