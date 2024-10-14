package com.jonvallet.micronaut.account;

import jakarta.inject.Singleton;

@Singleton
public class AccountService {
  private final AccountRepository accountRepository;

  public AccountService(AccountRepository accountRepository) {
    this.accountRepository = accountRepository;
  }

  public Account saveAccount(Account account) {
    return accountRepository.save(account);
  }
}
