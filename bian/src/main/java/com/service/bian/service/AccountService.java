package com.service.bian.service;

import java.sql.Timestamp;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.service.bian.domain.Account;
import com.service.bian.domain.Transaction;
import com.service.bian.domain.UserAccount;
import com.service.bian.repository.AccountRepository;
import com.service.bian.repository.TransactionRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class AccountService {

	@Autowired
	private AccountRepository accountRepository;

	@Autowired
	private TransactionRepository trancRep;

	public Flux<UserAccount> streamAccounts() {
		Flux<Long> interval = Flux.interval(Duration.ofSeconds(1));
		Flux<UserAccount> events = Flux.fromStream(
				Stream.generate(() -> new UserAccount("ABC", LocalDateTime.now().toString(), 100 * Math.random())));
		return Flux.zip(events, interval, (key, value) -> key);
	}

	public Mono<Account> findByAccountNumber(String accountNumber) {

		Account balance = accountRepository.findByAccountnumber(accountNumber);
		return Mono.just(Optional.ofNullable(balance).orElse(new Account()));
	}

	public Mono<List<Transaction>> findTransactionByDateRange(String accountNumber, Timestamp fromDate,
			Timestamp toDate) {

		List<Transaction> transc = trancRep.getTransactionByDate(accountNumber, fromDate, toDate);

		return Mono.just(transc);
	}

	public Mono<List<Transaction>> findTransactionByDateAndType(String accountNumber, String type, Timestamp fromDate,
			Timestamp toDate) {

		List<Transaction> transc = trancRep.getTransactionByDateAndType(accountNumber, type, fromDate, toDate);

		return Mono.just(transc);
	}

	

	public Mono<List<Transaction>> findTransactionByType(String accountNumber, String type) {
		return Mono.just(trancRep.getTransaction(accountNumber, type));
	}
}
