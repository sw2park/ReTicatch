package com.danaojo.reticatch.mypage.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.danaojo.reticatch.entity.Orders;

import jakarta.transaction.Transactional;

public interface OrdersRepository extends JpaRepository<Orders, Long> {
	@Query(value = "SELECT COUNT(*) FROM orders o WHERE seq_user_id = :seq_user_id", nativeQuery = true)
	int findByOrderCount(@Param("seq_user_id") Long seq_user_id);

	@Query(value = "SELECT * FROM orders WHERE seq_user_id = :user_seq", nativeQuery = true)
	List<Orders> getOrderDto(@Param("user_seq") Long user_seq);

	@Transactional
	@Modifying
	@Query(value = "UPDATE orders SET cancel_status = 'Y' WHERE seq_user_id = :userSeq AND seq_order_id = :orderSeq", nativeQuery = true)
	void updateOrderStatus(@Param("userSeq") Long userSeq, @Param("orderSeq") Long orderSeq);
}