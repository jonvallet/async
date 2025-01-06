package com.jonvallet.micronaut.payment;


import java.util.UUID;

public class Decision {
  private UUID id;
  private String decision;

  public Decision() {
  }

  public Decision(UUID id, String decision) {
    this.id = id;
    this.decision = decision;
  }

  public UUID getId() {
    return id;
  }

  public void setId(UUID id) {
    this.id = id;
  }

  public String getDecision() {
    return decision;
  }

  public void setDecision(String decision) {
    this.decision = decision;
  }
}
