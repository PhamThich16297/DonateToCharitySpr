package com.thichpham.dtc.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.thichpham.dtc.entity.Account;

public interface AccountService extends UserDetailsService{
	
	public Account findAccountByUserName(String userName);
	
}
