package com.jonvallet.micronaut.account;

import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.junit.jupiter.api.Assertions.assertNotNull;


@MicronautTest
public class AccountServiceIntegrationTest {

  @Inject
  AccountService accountService;

  @Test
  public void testSaveAccount() {
    var account = new Account(123456L, 1234567890L);
    accountService.saveAccount(account);

    assertNotNull(account);
    assertNotNull(account.getId());
  }

  @RepeatedTest(100)
  public void testSaveMultipleAccountsAccount() {
    var account = new Account(123456L, 1234567890L);
    accountService.saveAccount(account);

    assertNotNull(account);
    assertNotNull(account.getId());
  }
}
