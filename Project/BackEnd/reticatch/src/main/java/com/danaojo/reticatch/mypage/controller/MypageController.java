package com.danaojo.reticatch.mypage.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.danaojo.reticatch.entity.Users;
import com.danaojo.reticatch.mypage.dto.CancelReserveDTO;
import com.danaojo.reticatch.mypage.dto.ConfirmDTO;
import com.danaojo.reticatch.mypage.dto.PostReviewListDTO;
import com.danaojo.reticatch.mypage.dto.PostSomeCountDTO;
import com.danaojo.reticatch.mypage.dto.UserDTO;
import com.danaojo.reticatch.mypage.dto.postExceptionListDTO;
import com.danaojo.reticatch.mypage.service.MypageService;
import com.danaojo.reticatch.mypage.util.MypageUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

@CrossOrigin(origins = "http://localhost:3001")
@RestController
public class MypageController {
	@Autowired
	private MypageService mypageService;
	
	@PostMapping("/api/mypage/postSomeCount")
	public PostSomeCountDTO postSomeCount(@RequestBody String userId) {
		MypageUtil util = new MypageUtil();
		String noMarkUserId = util.deleteMarks(userId);
		
		PostSomeCountDTO pDto = mypageService.postSomeCount(noMarkUserId);
		
		return pDto;
	}
	
	@PostMapping("/api/mypage/postReviewList")
	public List<PostReviewListDTO> postReviewList(@RequestBody String userId) {
		MypageUtil util = new MypageUtil();
		String noMarkUserId = util.deleteMarks(userId);
		
		List<PostReviewListDTO> pList = mypageService.postReviewList(noMarkUserId); 
				
		return pList;
	}
	
	@PostMapping("/api/mypage/postExceptionList")
	public List<postExceptionListDTO> postExceptionList(@RequestBody String userId) {
		MypageUtil util = new MypageUtil();
		String noMarkUserId = util.deleteMarks(userId);
		
		List<postExceptionListDTO> pList = mypageService.postExceptionList(noMarkUserId); 
				
		return pList;
	}
	
	@PostMapping("/api/mypage/postDeleteUser")
	public void postDeleteUser(@RequestBody String userData) {
		MypageUtil util = new MypageUtil();
		String noMarkData = util.deleteMarks(userData);
		
		mypageService.postDeleteUser(noMarkData);
	}
	
	@PostMapping("/api/mypage/postUpdateUser")
	public void postUpdateUser(@RequestBody String userData) throws JsonMappingException, JsonProcessingException {
		MypageUtil util = new MypageUtil();
		
		UserDTO userDto = util.mappingUserDto(userData);
		mypageService.updateUserData(userDto);
	}
	
	@PostMapping("/api/mypage/postUserData")
	public Users postUserData(@RequestBody String userName) {
		MypageUtil util = new MypageUtil();
		String strUserName = util.deleteMarks(userName); // json으로 받아오기 때문에 "" 제거
		
		Users userData = mypageService.searchUserData(strUserName);
		
		return userData;
	}
	
	@PostMapping("/api/mypage/searchConfirmQuery")
	public List<ConfirmDTO> postConfirmQuery(@RequestBody String userName) {
		MypageUtil util = new MypageUtil();
		String strUserName = util.deleteMarks(userName); // json으로 받아오기 때문에 "" 제거
		
		List<ConfirmDTO> confirmList = mypageService.returnConfirmDTO(strUserName);
		
		return confirmList;
	}
	
	@PostMapping("/api/mypage/postCancelReserve")
	public void postCancelReserve(@RequestBody String data) throws JsonMappingException, JsonProcessingException {
		MypageUtil util = new MypageUtil();
		CancelReserveDTO cancelDto = util.mappingCancelDto(data);
		
		mypageService.cancelReserve(cancelDto);
	}
}