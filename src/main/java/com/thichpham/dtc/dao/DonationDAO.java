package com.thichpham.dtc.dao;

import java.util.List;

import com.thichpham.dtc.entity.Donation;

public interface DonationDAO {
	public List<Donation> getListDonation();
	public Donation getDonationById(int id);
}
