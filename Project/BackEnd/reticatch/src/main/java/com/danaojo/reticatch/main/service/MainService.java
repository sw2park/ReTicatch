package com.danaojo.reticatch.main.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.danaojo.reticatch.entity.PFJoin;
import com.danaojo.reticatch.mypage.repository.PfJoinRepository;

import jakarta.transaction.Transactional;

@Service
public class MainService {
	@Autowired
	private PfJoinRepository pfJoinRepository;
	
	@Transactional
	public List<PFJoin> getPfJoinApi() {
		List<PFJoin> pfJoinList = getPfjoinData();
		
		return pfJoinList;
	}
	public List<PFJoin> getPfjoinData(){
		return pfJoinRepository.getPfData();
	}
		
}