package com.danaojo.reticatch.detail.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.danaojo.reticatch.detail.service.DetailService;
import com.danaojo.reticatch.entity.PFJoin;
import com.danaojo.reticatch.mypage.util.MypageUtil;

@CrossOrigin(origins = "http://localhost:3001")
@RestController
public class DetailController {
	@Autowired
	private DetailService detailService;
	
	@PostMapping("/api/detail/postDetailData")
	public PFJoin postDetailData(@RequestBody String seqPfjoin){
		MypageUtil util = new MypageUtil();
		
		String noMarkSeq = util.deleteMarks(seqPfjoin);
		System.out.println(noMarkSeq);
		int seqNum = Integer.parseInt(noMarkSeq); 
		
		return detailService.getDetailData(seqNum);
	}
}
