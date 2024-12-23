package com.danaojo.reticatch.expectation.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.danaojo.reticatch.entity.Expectation;

public interface ExpectationRepository extends JpaRepository<Expectation, Long> {

	@Query (value = "SELECT * FROM expectation e  WHERE seq_pfjoin_id = :seqNum", nativeQuery = true)
	List<Expectation> findAllList(@Param("seqNum") String noMarkSeqNum);

	@Query (value = "SELECT * FROM expectation e WHERE seq_user_id = :userSeq", nativeQuery = true)
	List<Expectation> findByUserSeq(@Param("userSeq") Long userSeq);
	
	@Query (value = "SELECT COUNT(*) FROM expectation e WHERE seq_user_id = :userSeq", nativeQuery = true)
	int postSomeCount(@Param("userSeq") Long userSeq);
}
