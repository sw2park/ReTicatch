package com.danaojo.reticatch.login.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.danaojo.reticatch.entity.Users;
import com.danaojo.reticatch.login.logindto.LoginForm;
import com.danaojo.reticatch.login.service.LoginService;
import com.danaojo.reticatch.login.session.SessionConst;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class LoginController {
	private final LoginService loginService;

	@GetMapping("/login")
	public String loginForm(@ModelAttribute("loginForm") LoginForm loginForm) {
		return "login/loginForm";
	}

	@PostMapping("/api/login")
	public String login(@RequestBody String data, Model model, HttpServletRequest request)
			throws JsonMappingException, JsonProcessingException {
		LoginForm form = new LoginForm();
		ObjectMapper objMapper = new ObjectMapper();

		form = objMapper.readValue(data, LoginForm.class);

		Users loginMember = loginService.login(form.getLoginId(), form.getPassword());

		if (loginMember == null) {
			model.addAttribute("msg", "로그인에 실패하였습니다. 아이디와 비밀번호를 확인하세요.");
			return "login/loginForm";
		}

		// 세션 생성 및 로그인 정보 저장
		HttpSession session = request.getSession();
		session.setAttribute(SessionConst.LOGIN_MEMBER, loginMember);

		return "redirect:" + form.getRedirectURL();
	}

	@PostMapping("/logout")
	public String logout(HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		if (session != null) {
			session.invalidate();
		}
		return "redirect:/";
	}
}