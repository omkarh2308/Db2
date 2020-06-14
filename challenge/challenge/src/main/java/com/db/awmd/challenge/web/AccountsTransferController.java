package com.db.awmd.challenge.web;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.db.awmd.challenge.exception.InsufficientBalanceException;
import com.db.awmd.challenge.service.AccountsService;
import com.db.awmd.challenge.service.AccountsTransferService;

@RestController
public class AccountsTransferController {

	private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(AccountsController.class);

	@Autowired
	private  AccountsTransferService accountsTransferService;

	
	@PostMapping(path = "/transferAmt", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> transactionalDetails(@RequestParam("accountFrom") String accountFrom,
			@RequestParam("accountTo") String accountTo, @RequestParam("amount") BigDecimal amount) {
		log.info("Transfer amount from one to another account !!!!");
		try {
			this.accountsTransferService.transferAmount(accountFrom, accountTo, amount);
		} catch (InsufficientBalanceException ie) {
			return new ResponseEntity<>(ie.getMessage(), HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
