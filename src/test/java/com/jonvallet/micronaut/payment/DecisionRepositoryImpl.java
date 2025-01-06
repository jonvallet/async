package com.jonvallet.micronaut.payment;

import jakarta.inject.Singleton;

@Singleton
public class DecisionRepositoryImpl implements DecisionRepository {
  @Override
  public void save(Decision decision) {
    try {
      Thread.sleep(5000);
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }
  }
}
