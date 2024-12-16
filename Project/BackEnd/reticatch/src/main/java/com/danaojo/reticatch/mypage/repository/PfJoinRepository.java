package com.danaojo.reticatch.mypage.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.danaojo.reticatch.entity.PFJoin;

public interface PfJoinRepository extends JpaRepository<PFJoin, Long>{
	
	@Query(value = "SELECT p_title FROM pfjoin p WHERE seq_pfjoin_id = :pfJoinSeq", nativeQuery = true)
	String getTitle(Long pfJoinSeq);
}