package com.danaojo.reticatch.mypage.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.danaojo.reticatch.mypage.dto.ConfirmDTO;
import com.danaojo.reticatch.mypage.dto.ConfirmQueryDTO;
import com.danaojo.reticatch.mypage.service.MypageService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

@CrossOrigin(origins = "http://localhost:3001")
@RestController
public class MypageController {
	@Autowired
	private MypageService mypageService;
	
	@PostMapping("/api/mypage/searchConfirmQuery")
	public List<ConfirmDTO> postConfirmQuery(@RequestBody String userName) {
		String strUserName = userName.replace("\"", "");
		
		System.out.println("userName : " + strUserName);
		
		List<ConfirmDTO> confirmList = mypageService.returnConfirmDTO(strUserName);
		
		for(ConfirmDTO c : confirmList) {
			System.out.println(c.getPf_title());
		}
		
		return confirmList;
	}
}