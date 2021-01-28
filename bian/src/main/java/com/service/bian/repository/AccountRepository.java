package com.service.bian.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.service.bian.domain.Account;

@Repository

public interface AccountRepository extends  JpaRepository<Account, String>{
	
	
	
	public Account findByAccountnumber(String accountnumber);

}
