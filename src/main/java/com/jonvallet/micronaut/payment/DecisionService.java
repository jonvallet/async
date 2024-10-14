package com.jonvallet.micronaut.payment;

import jakarta.inject.Singleton;

import java.util.UUID;

@Singleton
public class DecisionService {

  private final DecisionRepository decisionRepository;

  public DecisionService(DecisionRepository decisionRepository) {
    this.decisionRepository = decisionRepository;
  }

  public void persist(Decision decision) {
    decisionRepository.save(decision);
  }
}
