package com.thichpham.dtc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.thichpham.dtc.entity.Donation;
import com.thichpham.dtc.service.DonationService;

@Controller
@RequestMapping("/trang-chu")
public class HomeController {
	
	@Autowired
	private DonationService donationService;
	
	@GetMapping("/")
	public String home(Model model) {
		model.addAttribute("listDonations", donationService.getListDonations());
		return "view-home/home";
	}
	
	@GetMapping("/donation-detail")
	public String getDonationById(Model model, @RequestParam(value = "id") int id) {
		Donation donation = donationService.getDonationById(id);
		model.addAttribute("donation", donation);
		return "view-home/donation-detail";
	}
	
}
