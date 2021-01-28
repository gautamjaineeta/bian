package com.service.bian.domain;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
public class Transaction {
	
	@Id
	@JsonIgnore
	private int id;
	private String accountnumber;
	private double amount;
	@JsonProperty("type")
	private String tranctype;
	@JsonProperty("transactionTs")
	private Timestamp trancdate;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAccountnumber() {
		return accountnumber;
	}
	public void setAccountnumber(String accountnumber) {
		this.accountnumber = accountnumber;
	}
	
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public String getTranctype() {
		return tranctype;
	}
	public void setTranctype(String tranctype) {
		this.tranctype = tranctype;
	}
	public Timestamp getTrancdate() {
		return trancdate;
	}
	public void setTrancdate(Timestamp trancdate) {
		this.trancdate = trancdate;
	}
	
	
	
	
	
	
	

}
