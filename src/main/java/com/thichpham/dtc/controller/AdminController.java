package com.thichpham.dtc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminController {
	
	@GetMapping("/admin-home")
	public String homeAdmin() {
		return "view-admin/admin-home";
	}
	
}
