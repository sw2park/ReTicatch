package com.danaojo.reticatch.login.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.danaojo.reticatch.entity.Users;
import com.danaojo.reticatch.login.session.SessionConst;

@Controller
public class HomeController {
	@GetMapping("/")
	public String home(@SessionAttribute(name = SessionConst.LOGIN_MEMBER, required = false) Users loginMember,
			Model model) {

		if (loginMember == null) {
			return "home";
		}

		model.addAttribute("member", loginMember);
		return "loginHome";
	}
}