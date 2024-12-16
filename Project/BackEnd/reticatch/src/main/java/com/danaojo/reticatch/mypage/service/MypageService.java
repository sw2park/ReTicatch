package com.danaojo.reticatch.mypage.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import com.danaojo.reticatch.entity.Orders;
import com.danaojo.reticatch.mypage.dto.ConfirmDTO;
import com.danaojo.reticatch.mypage.dto.ConfirmQueryDTO;
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
	public List<ConfirmDTO> returnConfirmDTO(ConfirmQueryDTO obj, String userName) {
		MypageUtil util = new MypageUtil();
		String mode = obj.getMode();
		String year = obj.getYear();
		String month = obj.getMonth();
		
		// 날짜 세팅 
		String prevDate = util.calcPrevDate(year, month); // 조건 시작일 ex) 12월 선택시 12-01로 변경
		String nextDate = util.calcNextDate(year, month); // 조건 끝나는날 ex_ 12월 선택시 12-31로 변경
		
		List<ConfirmDTO> confirmList = new ArrayList<>();
		
		Long userSeq = getUserSeq(userName);
		
		// 이전날짜 세팅 후 전달 > 쿼리문 변경
		List<Orders> orderList = getMypageOrder(userSeq, mode, prevDate, nextDate);
		for(Orders ocDto : orderList) {
			ConfirmDTO cDto = new ConfirmDTO();
			
			cDto.setAblecancleDate(ocDto.getCancel_date());
			cDto.setCancel_status(ocDto.getCancel_status());
			cDto.setPf_title(getTitle(ocDto.getSeq_pfjoin_id().getSeq_pfjoin_id()));
			cDto.setSeq_order_id(ocDto.getSeq_order_id());
			cDto.setTotal_ticket(ocDto.getTotal_ticket());
			cDto.setView_date(ocDto.getView_date());
			
			confirmList.add(cDto);
			
			// 테스트 출력
			System.out.println(cDto.getPf_title());
		}
		return confirmList; 
	}
	
	public String getTitle(Long pfJoinSeq) {
		return pfJoinRepository.getTitle(pfJoinSeq);
	}
	
	public List<Orders> getMypageOrder(Long userSeq, String mode, String prevDate, String nextDate) {
		return ordersRepository.getOrderDto(userSeq, mode, prevDate, nextDate);
	}
	
	public int getOrderCount(Long userSeq) {
		return ordersRepository.findByOrderCount(userSeq);
	}
	
	public Long getUserSeq(String userName) {
		return usersRepository.findByUser_Name(userName);
	}
}