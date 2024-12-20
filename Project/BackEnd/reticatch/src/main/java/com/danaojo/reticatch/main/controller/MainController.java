package com.danaojo.reticatch.main.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.danaojo.reticatch.entity.PFJoin;
import com.danaojo.reticatch.main.service.MainService;

@CrossOrigin(origins = "http://localhost:3001")
@Controller
@RestController
public class MainController {
	@Autowired
	private MainService mainService;
	
	@GetMapping("/api/getPfjoinApi")
	public List<PFJoin> getPfjoinApi() {
		List<PFJoin> pfJoinList = mainService.getPfJoinApi();
		
		return pfJoinList;
	}
}