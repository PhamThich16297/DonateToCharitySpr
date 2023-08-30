package com.thichpham.dtc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/trang-chu")
public class HomeController {
	
	@GetMapping("/")
	public String home(Model model) {
		model.addAttribute("nameWebSite", "Donate to Charity");
		return "view-home/home";
	}
	
}
