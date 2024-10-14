package com.jonvallet.micronaut.payment;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.util.UUID;

@Entity
public class Decision {
  @Id
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
