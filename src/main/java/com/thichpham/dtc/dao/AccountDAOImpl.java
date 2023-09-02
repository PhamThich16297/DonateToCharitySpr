package com.thichpham.dtc.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.thichpham.dtc.entity.Account;

@Repository
public class AccountDAOImpl implements AccountDAO{
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public Account findAccountByUserName(String userName) {
		Session currentSession = sessionFactory.getCurrentSession();
		Query<Account> theQuery = 
				currentSession.createQuery("from Account where user_name=:userName",
											Account.class);
		theQuery.setParameter("userName", userName);
		Account account = null;
		try {
			account = theQuery.getSingleResult();
		} catch (Exception e) {
			account = null;
		}
		return account;
	}

	
	
}
