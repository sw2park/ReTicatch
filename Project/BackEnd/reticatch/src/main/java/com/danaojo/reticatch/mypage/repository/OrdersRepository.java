package com.danaojo.reticatch.mypage.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.danaojo.reticatch.entity.Orders;

public interface OrdersRepository extends JpaRepository<Orders, Long> {
	@Query(value = "SELECT COUNT(*) FROM orders o WHERE seq_user_id = :seq_user_id", nativeQuery = true)
	int findByOrderCount(Long seq_user_id);

	@Query(value = "SELECT * FROM orders WHERE seq_user_id = :userSeq", nativeQuery = true)
	List<Orders> getOrderDto(@Param("userSeq") Long userSeq);
}
