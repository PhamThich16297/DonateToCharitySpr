package com.thichpham.dtc.entity;

import java.util.Collection;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
@Table(name="account")
public class Account implements UserDetails{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="user_name")
	private String userName;
	
	@Column(name="password")
	private String password;
	
	@Column(name="full_name")
	private String fullName;
	
	@Column(name="mail")
	private String mail;
	
	@Column(name="phone")
	private String phone;
	
	@Column(name="status")
	private int status;
	
	@ManyToMany(fetch = FetchType.LAZY,
				cascade = {CascadeType.DETACH, CascadeType.MERGE,
						CascadeType.PERSIST, CascadeType.REFRESH})
	@JoinTable(name="account_role",
				joinColumns = @JoinColumn(name="account_id"),
				inverseJoinColumns = @JoinColumn(name="role_id"))
	private List<Role> listRoles;
	
	@Transient
	private Collection<? extends GrantedAuthority> authorities;

	public Account() {}

	public Account(String userName, 
					String password, 
					String fullName, 
					String mail, 
					String phone, 
					int status,
					Collection<? extends GrantedAuthority> authorities) {
		this.userName = userName;
		this.password = password;
		this.fullName = fullName;
		this.mail = mail;
		this.phone = phone;
		this.status = status;
		this.authorities = authorities;
	}
	
	public int getId() {
		return id;
	}
	
	@Override
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public List<Role> getListRoles() {
		return listRoles;
	}

	public void setListRoles(List<Role> listRoles) {
		this.listRoles = listRoles;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return this.authorities;
	}

	@Override
	public String getUsername() {
		return this.userName;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		if(this.status == 1) {
			return true;
		}
		return false;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}
	
	
	
}
