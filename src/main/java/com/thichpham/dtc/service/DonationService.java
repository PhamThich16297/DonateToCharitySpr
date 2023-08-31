package com.thichpham.dtc.service;

import java.util.List;

import com.thichpham.dtc.entity.Donation;

public interface DonationService {
	public List<Donation> getListDonations();
	public Donation getDonationById(int id);
}
