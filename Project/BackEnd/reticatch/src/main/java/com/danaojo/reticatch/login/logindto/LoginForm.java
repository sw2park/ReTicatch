package com.danaojo.reticatch.login.logindto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class LoginForm {
	private String loginId;
	private String password;
	private String redirectURL;
}