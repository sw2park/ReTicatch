package com.danaojo.reticatch.mypage.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.danaojo.reticatch.entity.Orders;
import com.danaojo.reticatch.entity.Users;
import com.danaojo.reticatch.mypage.dto.CancelReserveDTO;
import com.danaojo.reticatch.mypage.dto.ConfirmDTO;
import com.danaojo.reticatch.mypage.dto.UserDTO;
import com.danaojo.reticatch.mypage.repository.OrdersRepository;
import com.danaojo.reticatch.mypage.repository.PfJoinRepository;
import com.danaojo.reticatch.mypage.repository.UsersRepository;
import com.danaojo.reticatch.mypage.util.MypageUtil;

import jakarta.transaction.Transactional;

@Service
public class MypageService {
	@Autowired
	private UsersRepository usersRepository;

	@Autowired
	private OrdersRepository ordersRepository;

	@Autowired
	private PfJoinRepository pfJoinRepository;

	@Transactional
	public void updateUserData(UserDTO data) {
		MypageUtil util = new MypageUtil();
		String today = util.returnToday();
		
		Long seq_user_id = data.getSeq_user_id();
		String userId = data.getUserId();
		String userPW = data.getUserPW();
		String userPhone = data.getUserPhone();
		String userName = data.getUserName();
		String userEmail = data.getUserEmail();
		String updateDate = today;
		
		updateUserDB(seq_user_id, userId, userPW, userPhone, userName,userEmail, updateDate);
	}


	@Transactional
	public Users searchUserData(String userName) {
		MypageUtil util = new MypageUtil();
		// user 시퀀스 아이디 찾기
		Long userSeq = getUserSeq(userName);

		// users 엔티티 사용해서 데이터 가져오기
		Users userData = searchByUserSeq(userSeq);

		// 전화번호 이쁘게 변환 ex)01012345678 → 010-****-5678
		userData.setUser_phone(util.changePhoneNum(userData.getUser_phone(), 0));

		// 로그인 타입 대문자로 고정 출력
		userData.setLogin_type(userData.getLogin_type().toUpperCase());

		return userData;
	}

	@Transactional
	public void cancelReserve(CancelReserveDTO cancelDto) {
		// user 시퀀스 아이디 찾기
		Long userSeq = getUserSeq(cancelDto.getUsername());

		// order 시퀀스 아이디 가져오기
		Long orderSeq = cancelDto.getSeq_order_id();

		// 각 테이블에 취소하려고 하는것 티켓매수 + 해주기
		// user 시퀀스와 order 시퀀스 값 맞춰서 해당 취소 상태 업데이트
		updateOrderStatus(userSeq, orderSeq);
	}

	@Transactional
	public List<ConfirmDTO> returnConfirmDTO(String userName) {
		List<ConfirmDTO> confirmList = new ArrayList<>();

		// 시퀀스 아이디 찾기
		Long userSeq = getUserSeq(userName);
		// 주문내역 조회
		List<Orders> orderList = getMypageOrder(userSeq);
		for (Orders ocDto : orderList) {
			ConfirmDTO cDto = new ConfirmDTO();

			cDto.setAblecancleDate(ocDto.getCancel_date());
			cDto.setCancel_status(ocDto.getCancel_status());
			cDto.setPf_title(getTitle(ocDto.getSeq_pfjoin_id().getSeq_pfjoin_id()));
			cDto.setSeq_order_id(ocDto.getSeq_order_id());
			cDto.setTotal_ticket(ocDto.getTotal_ticket());
			cDto.setView_date(ocDto.getView_date());
			confirmList.add(cDto);
		}
		return confirmList;
	}

	public Users searchByUserSeq(Long userSeq) {
		return usersRepository.searchUserData(userSeq);
	}

	public void updateOrderStatus(Long userSeq, Long orderSeq) {
		ordersRepository.updateOrderStatus(userSeq, orderSeq);
	}

	public String getTitle(Long pfJoinSeq) {
		return pfJoinRepository.getTitle(pfJoinSeq);
	}

	public List<Orders> getMypageOrder(Long userSeq) {
		return ordersRepository.getOrderDto(userSeq);
	}

	public int getOrderCount(Long userSeq) {
		return ordersRepository.findByOrderCount(userSeq);
	}

	public Long getUserSeq(String userName) {
		return usersRepository.findByUser_Name(userName);
	}
	
	public void updateUserDB(Long seq_user_id, String userId, String userPW, String userPhone, String userName,
			String userEmail, String updateDate) {
		usersRepository.updateUserDB(seq_user_id, userId, userPW, userPhone, userName, userEmail, updateDate);
	}
}