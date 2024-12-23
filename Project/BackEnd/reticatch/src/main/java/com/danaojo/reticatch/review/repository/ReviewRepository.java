package com.danaojo.reticatch.review.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.danaojo.reticatch.entity.Review;

public interface ReviewRepository extends JpaRepository<Review, Long> {
	@Query(value = "SELECT * FROM review r WHERE seq_pfjoin_id = :seqNum", nativeQuery = true)
	List<Review> findAllList(@Param("seqNum") String seqNum);

	@Query(value = "SELECT * FROM review r WHERE seq_user_id = :seqNum", nativeQuery = true)
	List<Review> findByUserSeq(@Param("seqNum") Long seqNum);

	@Query(value = "SELECT COUNT(*) FROM review r WHERE seq_user_id = :userSeq", nativeQuery = true)
	int postSomeCount(@Param("userSeq") Long userSeq);
}