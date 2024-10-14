package com.jonvallet.micronaut.account;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Account {
  @Id
  @GeneratedValue
  private Long id;
  private Long sortCode;
  private Long accountNumber;

  public Account() {
  }

  public Account(Long sortCode, Long accountNumber) {
    this.sortCode = sortCode;
    this.accountNumber = accountNumber;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Long getSortCode() {
    return sortCode;
  }

  public void setSortCode(Long sortCode) {
    this.sortCode = sortCode;
  }

  public Long getAccountNumber() {
    return accountNumber;
  }

  public void setAccountNumber(Long accountNumber) {
    this.accountNumber = accountNumber;
  }
}
