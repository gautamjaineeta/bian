package com.service.bian.domain;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
public class Account {
	
	@Id
	private String accountnumber;
	
	@JsonProperty("balance")
	private double amount;
	
	@JsonProperty("lastUpdateTimestamp")
	private Timestamp baldate;
	
	public String getAccountnumber() {
		return accountnumber;
	}

	public void setAccountnumber(String accountNumber) {
		this.accountnumber = accountNumber;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public Timestamp getBaldate() {
		return baldate;
	}

	public void setBaldate(Timestamp baldate) {
		this.baldate = baldate;
	}

	

}
