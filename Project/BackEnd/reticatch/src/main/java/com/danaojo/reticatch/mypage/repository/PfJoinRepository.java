package com.danaojo.reticatch.mypage.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.danaojo.reticatch.entity.PFJoin;

public interface PfJoinRepository extends JpaRepository<PFJoin, Long>{
	
	@Query(value = "SELECT p_title FROM pfjoin p WHERE seq_pfjoin_id = :pfJoinSeq", nativeQuery = true)
	String getTitle(@Param("pfJoinSeq") Long pfJoinSeq);

	@Query(value = "SELECT * FROM pfjoin", nativeQuery = true)
	List<PFJoin> getPfData();

	@Query(value = "SELECT * FROM pfjoin p WHERE seq_pfjoin_id = :seqNum", nativeQuery = true)
	PFJoin getDetailPfJoin(@Param("seqNum") int seqNum);
}