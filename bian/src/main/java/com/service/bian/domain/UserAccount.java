package com.service.bian.domain;

public class UserAccount {

	private String accountNumber;
	private String lastUpdateTimestamp;
	private double balance;

	public UserAccount() {

	}

	public UserAccount(String accountNumber, String lastUpdateTimestamp, double balance) {
		super();
		this.accountNumber = accountNumber;
		this.lastUpdateTimestamp = lastUpdateTimestamp;
		this.balance = balance;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getLastUpdateTimestamp() {
		return lastUpdateTimestamp;
	}

	public void setLastUpdateTimestamp(String lastUpdateTimestamp) {
		this.lastUpdateTimestamp = lastUpdateTimestamp;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}
}
