package com.school.management.model;

import com.school.management.domain.SchoolProfile;

/**
 * 
 * @author Aniket
 *
 */
public class SchoolProfileModel {

	private Long id;
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

	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "SchoolProfileModel [branch_name=" + branch_name + ", address=" + address + ", pincode=" + pincode
				+ ", phone_no=" + phone_no + ", emailid=" + emailid + "]";
	}

	public void wrapProfile(SchoolProfile profile) {
		this.branch_name = profile.getBranch_name();
		this.address = profile.getAddress();
		this.pincode = profile.getPincode();
		this.phone_no = profile.getPhone_no();
		this.emailid = profile.getEmailid();
		this.id = profile.getId();

	}

}
