package com.thichpham.dtc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {
	
	@GetMapping("/dang-nhap")
	public String login() {
		return "view-account/log-in";
	}
	
	@GetMapping("/access-denied")
	public String accessDenied() {
		return "view-account/access-denied";
	}
}
