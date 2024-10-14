package com.jonvallet.micronaut.payment;

import io.micronaut.data.annotation.Repository;
import io.micronaut.data.repository.CrudRepository;

import java.util.UUID;

@Repository
public interface DecisionRepository extends CrudRepository<Decision, UUID> {
}
