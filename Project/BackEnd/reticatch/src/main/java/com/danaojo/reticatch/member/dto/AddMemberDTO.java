package com.danaojo.reticatch.member.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class AddMemberDTO {
	private String loginId;
	private String password;
	private String passwordConfirm;
	private String userName;
	private String phone;
}