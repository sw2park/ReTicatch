package com.danaojo.reticatch.detail.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.danaojo.reticatch.entity.PFJoin;
import com.danaojo.reticatch.mypage.repository.PfJoinRepository;

import jakarta.transaction.Transactional;

@Service
public class DetailService {
	@Autowired
	private PfJoinRepository pfJoinRepository;
	
	@Transactional
	public PFJoin getDetailData(int seqNum){
		PFJoin pfData = getDetatilPfJoin(seqNum);
		
		return pfData;
	}
	
	public PFJoin getDetatilPfJoin(int seqNum) {
		return pfJoinRepository.getDetailPfJoin(seqNum);
	}
}