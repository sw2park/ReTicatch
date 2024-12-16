package com.danaojo.reticatch.mypage.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.danaojo.reticatch.entity.Expectation;

public interface ExpectationsRepository extends JpaRepository<Expectation, Long>{
	
}