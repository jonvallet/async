package com.jonvallet.micronaut.payment;

import io.micronaut.serde.annotation.Serdeable;

import java.util.UUID;

@Serdeable
public record PaymentRequest(UUID paymentId) {
}
