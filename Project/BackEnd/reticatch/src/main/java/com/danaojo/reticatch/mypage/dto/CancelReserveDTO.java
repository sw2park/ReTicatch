package com.danaojo.reticatch.mypage.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class CancelReserveDTO {
	private Long seq_order_id;
	private String pf_title;
	private String view_date;
	private String total_ticket;
	private String ablecancleDate;
	private String cancel_status;
	private String username;
}