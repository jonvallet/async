package com.jonvallet.micronaut.payment;

import io.micronaut.scheduling.TaskExecutors;
import io.micronaut.scheduling.annotation.Async;
import jakarta.inject.Singleton;

@Singleton
public class DecisionService {

  private final DecisionRepository decisionRepository;

  public DecisionService(DecisionRepository decisionRepository) {
    this.decisionRepository = decisionRepository;
  }

  @Async(TaskExecutors.VIRTUAL)
  public void persist(Decision decision) {
    decisionRepository.save(decision);
  }
}
