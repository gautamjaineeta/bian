package com.service.bian.controller;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.service.bian.domain.Account;
import com.service.bian.domain.Transaction;
import com.service.bian.service.AccountService;

import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/account")
public class AccountController {

	@Autowired
	AccountService accountService;

	@GetMapping(value = "/{accountNumber}", produces = MediaType.APPLICATION_JSON_VALUE)
	private Mono<Account> findByAccountNumber(@PathVariable String accountNumber) {
		return accountService.findByAccountNumber(accountNumber);
	}

	@GetMapping(value = "/{accountNumber}/{type}/{fromDate}/{toDate}", produces = MediaType.APPLICATION_JSON_VALUE)
	private Mono<List<Transaction>> findByAccountNumber(@PathVariable String accountNumber,
			@PathVariable(required = false) String type, @PathVariable String fromDate, @PathVariable String toDate)
			throws ParseException {

		SimpleDateFormat datetimeFormatter1 = new SimpleDateFormat("yyyy-MM-dd");
		Date lFromDate1 = datetimeFormatter1.parse(fromDate);
		Timestamp fromTS1 = new Timestamp(lFromDate1.getTime());

		Date ltoDate1 = datetimeFormatter1.parse(toDate);
		Timestamp toS1 = new Timestamp(ltoDate1.getTime());

		if (Objects.nonNull(type)) {

			return accountService.findTransactionByDateAndType(accountNumber, type, fromTS1, toS1);
		} else {

			return accountService.findTransactionByDateRange(accountNumber, fromTS1, toS1);
		}
	}

}
