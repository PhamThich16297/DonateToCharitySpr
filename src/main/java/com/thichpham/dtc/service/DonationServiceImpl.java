package com.thichpham.dtc.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thichpham.dtc.dao.DonationDAO;
import com.thichpham.dtc.entity.Donation;

@Service
public class DonationServiceImpl implements DonationService{
	
	@Autowired
	private DonationDAO donationDAO;
	
	@Override
	@Transactional
	public List<Donation> getListDonations() {
		return donationDAO.getListDonation();
	}

	@Override
	@Transactional
	public Donation getDonationById(int id) {
		return donationDAO.getDonationById(id);
	}
	
	
	
}
