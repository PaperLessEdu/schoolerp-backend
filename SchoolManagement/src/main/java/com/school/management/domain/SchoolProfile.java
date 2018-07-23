package com.school.management.domain;

import javax.persistence.Column;

public class SchoolProfile {

	private long id;
	@Column(name = "branch name")
	private String branch_name;

	@Column(name = "address")
	private String address;
	
	@Column(name = "pincode")
	private String pincode;

	@Column(name = "phone no")
	private String phone_no;
	
	@Column(name = "emailid")
	private String emailid;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getBranch_name() {
		return branch_name;
	}

	public void setBranch_name(String branch_name) {
		this.branch_name = branch_name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	public String getPhone_no() {
		return phone_no;
	}

	public void setPhone_no(String phone_no) {
		this.phone_no = phone_no;
	}

	public String getEmailid() {
		return emailid;
	}

	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}

	
    
 }

