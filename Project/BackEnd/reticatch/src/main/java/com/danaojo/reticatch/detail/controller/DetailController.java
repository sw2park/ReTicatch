package com.danaojo.reticatch.detail.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.danaojo.reticatch.detail.dto.AddExpectationDTO;
import com.danaojo.reticatch.detail.dto.AddOrderDTO;
import com.danaojo.reticatch.detail.dto.AddReviewDTO;
import com.danaojo.reticatch.detail.service.DetailService;
import com.danaojo.reticatch.entity.Expectation;
import com.danaojo.reticatch.entity.PFJoin;
import com.danaojo.reticatch.entity.Review;
import com.danaojo.reticatch.mypage.util.MypageUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

@CrossOrigin(origins = "http://localhost:3001")
@RestController
public class DetailController {
	@Autowired
	private DetailService detailService;
	
	@PostMapping("/api/detail/postExpectationList")
	public List<Expectation> postExpectationList(@RequestBody String seqNum) {
		MypageUtil util = new MypageUtil();
		String noMarkSeqNum = util.deleteMarks(seqNum);
		
		List<Expectation> expectationList = new ArrayList<>();
		expectationList = detailService.getExpectationList(noMarkSeqNum);
		
		return expectationList;
	}
	
	@PostMapping("/api/detail/postAddExpectation")
	public void postAddExpectation(@RequestBody String reqData) throws JsonMappingException, JsonProcessingException {
		MypageUtil util = new MypageUtil();
		AddExpectationDTO aDto = util.mappingAddExpectation(reqData);
		
		detailService.postAddExpectation(aDto);
	}
	
	@PostMapping("/api/detail/postAddReview")
	public void posrAddReview(@RequestBody String reqData) throws JsonMappingException, JsonProcessingException {
		MypageUtil util = new MypageUtil();
		AddReviewDTO aDto = util.mappingAddReviewDto(reqData);
		
		detailService.postAddReview(aDto);
	}
	
	@PostMapping("/api/detail/postReviewData")
	public List<Review> postReviewData(@RequestBody String seqNum) {
		MypageUtil util = new MypageUtil();
		String noMarkSeqNum = util.deleteMarks(seqNum);
		
		List<Review> reviewList = new ArrayList<>();
		reviewList = detailService.getReviewList(noMarkSeqNum);
		
		return reviewList;
	}
	
	@PostMapping("/api/detail/postAddOrders")
	public void postAddOrders(@RequestBody String reqData) throws JsonMappingException, JsonProcessingException {
		MypageUtil util = new MypageUtil();
		
		AddOrderDTO aDto = util.mappingAddOrderDto(reqData);
		
		System.out.println(aDto.getUserId());
		System.out.println(aDto.getSeqpfjoinId());
		
		detailService.addOrderData(aDto);
	}

	@PostMapping("/api/detail/postDetailData")
	public PFJoin postDetailData(@RequestBody String seqPfjoin) {
		MypageUtil util = new MypageUtil();

		String noMarkSeq = util.deleteMarks(seqPfjoin);
		
		int seqNum = Integer.parseInt(noMarkSeq);

		return detailService.getDetailData(seqNum);
	}

	@PostMapping("/api/detail/postDetailImage")
	public List<String> postDetailImage(@RequestBody String seqPfjoin) {
		MypageUtil util = new MypageUtil();

		// 마크 제거
		String noMarkSeq = util.deleteMarks(seqPfjoin);

		// 입력값 검증 및 숫자로 변환
		int seqNum;

		try {
			seqNum = Integer.parseInt(noMarkSeq);
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException("Invalid sequence number: " + noMarkSeq, e);
		}

		// 이미지 문자열 가져오기
		String imgStr = detailService.getDetailImage(seqNum);

		// 문자열 분리
		List<String> test = util.splitString(imgStr);

		return test; // 분리된 데이터를 반환
	}
}
