package com.thichpham.dtc.sercurity;

import org.springframework.security.core.context.SecurityContextHolder;

import com.thichpham.dtc.entity.Account;

public class SecurityUtil {

	public static Account getPrincipal() {
        return (Account) (SecurityContextHolder.getContext()).getAuthentication().getPrincipal();
    }
	
}
