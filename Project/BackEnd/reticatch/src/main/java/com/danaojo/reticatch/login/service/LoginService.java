package com.danaojo.reticatch.login.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.danaojo.reticatch.entity.Users;
import com.danaojo.reticatch.member.repository.MemberRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class LoginService {
	@Autowired
	private final MemberRepository memberRepository;

    public Users login(String loginId, String password) {
        Optional<Users> optionalMember = memberRepository.findByUser_id(loginId);
        return optionalMember.filter(member -> member.getUser_pw().equals(password)).orElse(null);
    }
}