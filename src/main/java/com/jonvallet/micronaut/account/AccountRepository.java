package com.jonvallet.micronaut.account;

import io.micronaut.data.annotation.Repository;
import io.micronaut.data.repository.CrudRepository;

@Repository
public interface AccountRepository extends CrudRepository<Account, Long> {
}
