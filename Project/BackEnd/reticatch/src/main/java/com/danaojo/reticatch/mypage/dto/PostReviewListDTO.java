package com.danaojo.reticatch.mypage.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class PostReviewListDTO {
	private String ticketName;
	private String context;
	private String date;
	private Long seq_pfJoin_id;
}