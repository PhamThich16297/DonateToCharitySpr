package com.thichpham.dtc.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.thichpham.dtc.entity.Donation;

@Repository
public class DonationDAOImpl implements DonationDAO{
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Donation> getListDonation() {
		Session currentSession = sessionFactory.getCurrentSession();
		Query<Donation> theQuery = 
				currentSession.createQuery("from Donation", Donation.class);
		return theQuery.getResultList();
	}

	@Override
	public Donation getDonationById(int id) {
		Session currentSession = sessionFactory.getCurrentSession();
		Donation donation = currentSession.get(Donation.class, id);
		return donation;
	}
	
	
}
