package com.db.awmd.challenge.service;

import java.math.BigDecimal;

import org.springframework.stereotype.Service;

import com.db.awmd.challenge.repository.AccountsRepository;

import lombok.Getter;

@Service
public class AccountsTransferService {

	
	@Getter
	private  AccountsRepository accountsRepository;
	
	public void transferAmount(String accountFrom, String accountTo, BigDecimal amount) {
		this.accountsRepository.transferAmount(accountFrom, accountTo, amount);
	}

}
