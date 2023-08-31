package com.thichpham.dtc.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "organization")
public class Organization {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "name")
	private String name;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "organization_detail_id")
	private OrganizationDetail organizationDetail;

	@OneToMany(mappedBy = "org", fetch = FetchType.LAZY, cascade = { CascadeType.DETACH, CascadeType.MERGE,
			CascadeType.PERSIST, CascadeType.REFRESH })
	private List<Donation> listDonations;

	public Organization() {
	}

	public Organization(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public OrganizationDetail getOrganizationDetail() {
		return organizationDetail;
	}

	public void setOrganizationDetail(OrganizationDetail organizationDetail) {
		this.organizationDetail = organizationDetail;
	}

	public List<Donation> getListDonations() {
		return listDonations;
	}

	public void setListDonations(List<Donation> listDonations) {
		this.listDonations = listDonations;
	}

}
