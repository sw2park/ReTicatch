package com.danaojo.reticatch.api.testcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.danaojo.reticatch.api.service.KopisService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

@Controller
public class testController {
	@Autowired
	private KopisService kopisService;
	
	@RequestMapping("/api/save")
	public String saveList() throws JsonMappingException, JsonProcessingException {
		kopisService.savePFJoin();
		
		return null;
	}
}
