package com.danaojo.reticatch.member.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.danaojo.reticatch.entity.Users;
import com.danaojo.reticatch.member.dto.AddMemberDTO;
import com.danaojo.reticatch.member.repository.MemberRepository;
import com.danaojo.reticatch.mypage.dto.UserDTO;
import com.danaojo.reticatch.mypage.util.MypageUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class MemberController {
	private final MemberRepository memberRepository;

    // 회원 등록 폼
    @GetMapping("/members/add")
    public String addForm(@ModelAttribute("member") Users member) {
        return "members/addMemberForm";
    }

    // 회원 등록 처리
    @PostMapping("/api/members/add")
    public void saveMember(@RequestBody String data) throws JsonMappingException, JsonProcessingException {
    	AddMemberDTO mDto = new AddMemberDTO();
    	ObjectMapper objMapper = new ObjectMapper();
    	
    	mDto = objMapper.readValue(data, AddMemberDTO.class);
    	
        // 중복 아이디 체크 // @ModelAttribute Users member, 
        if (memberRepository.findByUser_id(mDto.getLoginId()).isPresent()) {
        	
//            model.addAttribute("error", "이미 존재하는 아이디입니다.");
//            return "members/addMemberForm"; // 에러 메시지와 함께 다시 폼으로 이동
        }
        MypageUtil util = new MypageUtil();
        String today = util.returnToday();
        
        String loginId = mDto.getLoginId();
        String loginPW = mDto.getPassword();
        String userName = mDto.getUserName();
        String userPhone = mDto.getPhone();
        String userEmail = null;
        String loginType = "none";
        String createDate = today;
        String updateDate = today;

        // 회원 저장
        memberRepository.addUserData(loginId, loginPW, userName, userPhone, userEmail, loginType, createDate, updateDate);
        
//        return "redirect:/"; // 메인 페이지로 리다이렉트
    }
}