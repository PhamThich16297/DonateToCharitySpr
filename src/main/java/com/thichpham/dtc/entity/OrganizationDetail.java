package com.thichpham.dtc.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="organization_detail")
public class OrganizationDetail {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="url_img_logo")
	private String urlImgLogo;
	
	@Column(name="description")
	private String description;
	
	@Column(name="address")
	private String address;
	
	@Column(name="email")
	private String email;
	
	@Column(name="facebook")
	private String facebook;
	
	@Column(name="phone")
	private String phone;
	
	@OneToOne(mappedBy = "organizationDetail",
				cascade = CascadeType.ALL)
	private Organization org;

	public OrganizationDetail() {}

	public OrganizationDetail(String urlImgLogo, String description, String address, String email, String facebook,
			String phone) {
		this.urlImgLogo = urlImgLogo;
		this.description = description;
		this.address = address;
		this.email = email;
		this.facebook = facebook;
		this.phone = phone;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUrlImgLogo() {
		return urlImgLogo;
	}

	public void setUrlImgLogo(String urlImgLogo) {
		this.urlImgLogo = urlImgLogo;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFacebook() {
		return facebook;
	}

	public void setFacebook(String facebook) {
		this.facebook = facebook;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Organization getOrg() {
		return org;
	}

	public void setOrg(Organization org) {
		this.org = org;
	}
	
	
	
}

















