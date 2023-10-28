package com.imaginnovate.employees.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Phone {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@ManyToOne(fetch=FetchType.LAZY)
	private Employee emp;
	
	@Column(name="COUNTRY_CODE")
	private String countryCode = "+91";

	@Column(name="PHONE_NUMBER")
	private long mobileNumber;
	
	@Column(name="USE_TYPE")
	private String type;// expected value Office, Home
	
	@Column(name="PRIMARY")
	private boolean isPrimary = false;
	
	
	public String getCountryCode() {
		return countryCode;
	}
	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}
	public long getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public boolean isPrimary() {
		return isPrimary;
	}
	public void setPrimary(boolean isPrimary) {
		this.isPrimary = isPrimary;
	}

}
