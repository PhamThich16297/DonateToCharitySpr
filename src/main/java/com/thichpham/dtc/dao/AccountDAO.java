package com.thichpham.dtc.dao;

import org.springframework.security.core.userdetails.UserDetails;

import com.thichpham.dtc.entity.Account;

public interface AccountDAO{
	
	public Account findAccountByUserName(String userName);
	
}
