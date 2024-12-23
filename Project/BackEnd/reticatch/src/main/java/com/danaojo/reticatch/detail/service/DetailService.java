package com.danaojo.reticatch.detail.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.danaojo.reticatch.detail.dto.AddExpectationDTO;
import com.danaojo.reticatch.detail.dto.AddOrderDTO;
import com.danaojo.reticatch.detail.dto.AddReviewDTO;
import com.danaojo.reticatch.entity.Expectation;
import com.danaojo.reticatch.entity.Orders;
import com.danaojo.reticatch.entity.PFJoin;
import com.danaojo.reticatch.entity.Review;
import com.danaojo.reticatch.entity.Users;
import com.danaojo.reticatch.expectation.repository.ExpectationRepository;
import com.danaojo.reticatch.mypage.repository.OrdersRepository;
import com.danaojo.reticatch.mypage.repository.PfJoinRepository;
import com.danaojo.reticatch.mypage.repository.UsersRepository;
import com.danaojo.reticatch.mypage.util.MypageUtil;
import com.danaojo.reticatch.review.repository.ReviewRepository;

import jakarta.transaction.Transactional;

@Service
public class DetailService {
	@Autowired
	private PfJoinRepository pfJoinRepository;
	
	@Autowired
	private OrdersRepository orderRepository;
	
	@Autowired 
	private UsersRepository usersRepository;
	
	@Autowired
	private ReviewRepository reviewRepository;
	
	@Autowired
	private ExpectationRepository expectationRepository;
	
	@Transactional
	public PFJoin getDetailData(int seqNum){
		PFJoin pfData = getDetatilPfJoin(seqNum);
		
		return pfData;
	}
	
	public PFJoin getDetatilPfJoin(int seqNum) {
		return pfJoinRepository.getDetailPfJoin(seqNum);
	}

	public String getDetailImage(int seqNum) {
		return pfJoinRepository.getDetailImage(seqNum);
	}

	@Transactional
	public void addOrderData(AddOrderDTO aDto) {
		MypageUtil util = new MypageUtil();
		String today = util.returnToday();
		int seqPfNum = aDto.getSeqpfjoinId();
		String userId = aDto.getUserId();
		
		Long userSeq = null;
		userSeq = usersRepository.findByUser_Name(userId);
		
		Users userData = usersRepository.searchUserData(userSeq);
		PFJoin pfData = pfJoinRepository.getDetailPfJoin(seqPfNum);
		String viewDate = pfData.getP_start_date();
		String viewTime = pfData.getPd_time();
		String place = pfData.getPd_hall_name();
		
		Orders oEntity = new Orders();
		
		oEntity.setCancel_status("N");
		oEntity.setCancel_date("2025-12-24");
		oEntity.setBuy_date(today);
		oEntity.setTotal_sum("무료");
		oEntity.setTotal_ticket("1");
		oEntity.setView_date(viewDate);
		oEntity.setView_time(viewTime);
		oEntity.setSeat_num("0");
		oEntity.setPlace(place);
		oEntity.setSeq_user_id(userData);
		oEntity.setSeq_pfjoin_id(pfData);
		
		orderRepository.save(oEntity);
	}

	public List<Review> getReviewList(String noMarkSeqNum) {
		List<Review> reviewList = reviewRepository.findAllList(noMarkSeqNum);
		
		return reviewList;
	}

	public void postAddReview(AddReviewDTO reviewData) {
		MypageUtil util = new MypageUtil();
		String today = util.returnToday();
		
		Long userSeq = null;
		userSeq = usersRepository.findByUser_Name(reviewData.getUserId());
		
		Users userData = usersRepository.searchUserData(userSeq);
		PFJoin pfData = pfJoinRepository.getDetailPfJoin(reviewData.getPfJoinSeqNum());
		
		Review rEntity = new Review();
		
		rEntity.setRating(null);
		rEntity.setReview_content(reviewData.getTextData());
		rEntity.setSeq_pfjoin_id(pfData);
		rEntity.setReview_date(today);
		rEntity.setSeq_user_id(userData);
		
		reviewRepository.save(rEntity);
	}

	public void postAddExpectation(AddExpectationDTO aDto) {
		MypageUtil util = new MypageUtil();
		String today = util.returnToday();
		
		Long userSeq = null;
		userSeq = usersRepository.findByUser_Name(aDto.getUserId());
		
		Users userData = usersRepository.searchUserData(userSeq);
		PFJoin pfData = pfJoinRepository.getDetailPfJoin(aDto.getPfJoinSeqNum());
		
		Expectation eEntity = new Expectation();
		
		eEntity.setExp_content(aDto.getTextData());
		eEntity.setExp_date(today);
		eEntity.setSeq_pfjoin_id(pfData);
		eEntity.setSeq_user_id(userData);
		eEntity.setUser_id(userData.getUser_id());
		
		expectationRepository.save(eEntity);
	}

	public List<Expectation> getExpectationList(String noMarkSeqNum) {
		List<Expectation> expectationList = expectationRepository.findAllList(noMarkSeqNum);
		
		return expectationList;
	}	
}