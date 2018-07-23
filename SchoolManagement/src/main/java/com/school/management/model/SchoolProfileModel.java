package com.school.management.model;

public class SchoolProfileModel {

	private String branch_name;
	private String address;
	private String pincode;
	private String phone_no;
	private String emailid;

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

	public void wrapProfile(SchoolProfileModel profile) {

		this.branch_name = profile.getBranch_name();
		this.address = profile.getAddress();
		this.pincode = profile.getPincode();
		this.phone_no = profile.getPhone_no();
		this.emailid = profile.getEmailid();

	}
}
