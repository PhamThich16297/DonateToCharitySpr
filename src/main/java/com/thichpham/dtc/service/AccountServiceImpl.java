package com.thichpham.dtc.service;

import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thichpham.dtc.dao.AccountDAO;
import com.thichpham.dtc.entity.Account;
import com.thichpham.dtc.entity.Role;

@Service
public class AccountServiceImpl implements AccountService{

	@Autowired
	private AccountDAO accountDAO;
	
	@Override
	@Transactional
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Account account = accountDAO.findAccountByUserName(username);
		if(account == null) {
			throw new UsernameNotFoundException("User Name / password not valid !!!");
		}
		return new Account(account.getUsername(), 
							account.getPassword(), 
							account.getFullName(), 
							account.getMail(), 
							account.getPhone(), 
							account.getStatus(),
							mapRolesToAuthorities(account.getListRoles()));
	}

	private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles) {
		return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
	}
	
	@Override
	@Transactional
	public Account findAccountByUserName(String userName) {
		return accountDAO.findAccountByUserName(userName);
	}

	
	
}
