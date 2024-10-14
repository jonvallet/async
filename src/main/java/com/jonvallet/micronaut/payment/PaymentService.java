package com.jonvallet.micronaut.payment;

import jakarta.inject.Singleton;

import java.util.UUID;

@Singleton
public class PaymentService {
  private final DecisionRepository decisionRepository;

  public PaymentService(DecisionRepository decisionRepository) {
    this.decisionRepository = decisionRepository;
  }

  public String authorisePayment(UUID paymentId) {
    var decision = verify(paymentId);
    decisionRepository.save(new Decision(paymentId, decision));
    return decision;
  }

  private String verify(UUID paymentId) {
    if (paymentId.hashCode() % 2 == 0) {
      return "APPROVE";
    } else {
      return "DECLINE";
    }
  }
}
