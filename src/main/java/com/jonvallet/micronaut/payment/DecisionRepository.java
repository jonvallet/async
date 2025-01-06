package com.jonvallet.micronaut.payment;


public interface DecisionRepository {
  void save(Decision decision);
}
