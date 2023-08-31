package com.thichpham.dtc.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="donation")
public class Donation {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="title")
	private String title;
	
	@Column(name="url_img_banner")
	private String urlImgBanner;
	
	@Column(name="create_date")
	private Date createDate;
	
	@Column(name="start_date")
	private Date startDate;
	
	@Column(name="end_date")
	private Date endDate;
	
	@Column(name="total_money")
	private float totalMoney;
	
	@Column(name="active_status")
	private int activeStatus;
	
	@ManyToOne(fetch = FetchType.EAGER,
				cascade = {CascadeType.DETACH, CascadeType.MERGE,
							CascadeType.PERSIST, CascadeType.REFRESH})
	@JoinColumn(name="organization_id")
	private Organization org;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="donation_detail_id")
	private DonationDetail donationDetail;

	public Donation() {}

	public Donation(String title, String urlImgBanner, Date createDate, Date startDate, Date endDate, float totalMoney,
			int activeStatus) {
		this.title = title;
		this.urlImgBanner = urlImgBanner;
		this.createDate = createDate;
		this.startDate = startDate;
		this.endDate = endDate;
		this.totalMoney = totalMoney;
		this.activeStatus = activeStatus;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getUrlImgBanner() {
		return urlImgBanner;
	}

	public void setUrlImgBanner(String urlImgBanner) {
		this.urlImgBanner = urlImgBanner;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public float getTotalMoney() {
		return totalMoney;
	}

	public void setTotalMoney(float totalMoney) {
		this.totalMoney = totalMoney;
	}

	public int getActiveStatus() {
		return activeStatus;
	}

	public void setActiveStatus(int activeStatus) {
		this.activeStatus = activeStatus;
	}

	public Organization getOrg() {
		return org;
	}

	public void setOrg(Organization org) {
		this.org = org;
	}

	public DonationDetail getDonationDetail() {
		return donationDetail;
	}

	public void setDonationDetail(DonationDetail donationDetail) {
		this.donationDetail = donationDetail;
	}
	
	
	
}











