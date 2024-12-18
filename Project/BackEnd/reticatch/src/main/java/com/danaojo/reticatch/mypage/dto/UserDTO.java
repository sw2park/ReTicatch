package com.danaojo.reticatch.mypage.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class UserDTO {
	private Long seq_user_id;
	private String userId;
	private String userPW;
	private String userName;
	private String userPhone;
	private String userEmail;
}