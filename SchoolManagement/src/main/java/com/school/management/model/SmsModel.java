package com.school.management.model;

/**
 * 
 * @author Pavan.Pawar
 *
 */
public class SmsModel {

	private String phonenumber;
	private String body;

	public String getPhonenumber() {
		return phonenumber;
	}

	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	@Override
	public String toString() {
		return "SmsModel [phonenumber=" + phonenumber + ", body=" + body + "]";
	}

}
