package com.service.bian.repository;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.service.bian.domain.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Integer> {

	@Query("select t from Transaction t where t.accountnumber= :accountNumber and t.trancdate BETWEEN :startDate and :endDate")
	public List<Transaction> getTransactionByDate(String accountNumber, Timestamp startDate, Timestamp endDate);

	@Query("select t from Transaction t where t.accountnumber= :accountNumber and t.tranctype=:type and t.trancdate BETWEEN :startDate and :endDate")
	public List<Transaction> getTransactionByDateAndType(String accountNumber, String type, Timestamp startDate,
			Timestamp endDate);

	@Query("select t from Transaction t where t.accountnumber= :accountNumber and t.tranctype=:tranctype")
	public List<Transaction> getTransaction(String accountNumber, String tranctype);
}
