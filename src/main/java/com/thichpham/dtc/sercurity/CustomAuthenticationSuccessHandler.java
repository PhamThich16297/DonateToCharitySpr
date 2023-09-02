package com.thichpham.dtc.sercurity;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import com.thichpham.dtc.entity.Account;
import com.thichpham.dtc.service.AccountService;


@Component
public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    @Autowired
    private AccountService accountService;
	
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request,
										HttpServletResponse response,
										Authentication authentication)
			throws IOException, ServletException {

		String userName = authentication.getName();

		Account account = accountService.findAccountByUserName(userName);
		
		System.out.println(account.getUsername());
		System.out.println(account.getFullName());
		// now place in the session
		HttpSession session = request.getSession();
		session.setAttribute("user", account);
		
		// forward to home page
		
		response.sendRedirect(request.getContextPath() + "/");
	}

}
