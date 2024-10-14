package com.jonvallet.micronaut.payment;

import jakarta.inject.Singleton;

import java.util.UUID;

@Singleton
public class PaymentService {

  private final DecisionService decisionService;

  public PaymentService(DecisionService decisionService) {
    this.decisionService = decisionService;
  }


  public String authorisePayment(UUID paymentId) {
    var decision = verify(paymentId);
    decisionService.persist(new Decision(paymentId, decision));
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
