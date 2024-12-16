package com.danaojo.reticatch.api.repository;

import org.springframework.stereotype.Repository;

import com.danaojo.reticatch.entity.PFJoin;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class KopisRepository {
	@PersistenceContext
	private final EntityManager em;
	
	// PFJoinDB 저장
	public void savePFJoinList(PFJoin pfjoin) {
		em.persist(pfjoin);
	}
}