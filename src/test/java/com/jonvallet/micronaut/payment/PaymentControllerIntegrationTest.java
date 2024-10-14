package com.jonvallet.micronaut.payment;

import io.micronaut.http.HttpRequest;
import io.micronaut.http.client.HttpClient;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;


@MicronautTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class PaymentControllerIntegrationTest {

  @Inject
  @Client("/")
  HttpClient client;

  @Test
  @Order(1)
  public void testStatus() {
    var status = client.toBlocking().retrieve(HttpRequest.GET("/payment/status"));

    assertEquals("UP", status);
  }

  @Test
  @Order(2)
  public void testAuthorisePayment() {

    HttpRequest<PaymentRequest> request = HttpRequest.POST("/payment/authorise", new PaymentRequest(UUID.randomUUID()));

    String response = client.toBlocking().retrieve(request);

    assertNotNull(response);
  }

  @RepeatedTest(100)
  @Order(3)
  public void testMultipleAuthorisePayment() {

    HttpRequest<PaymentRequest> request = HttpRequest.POST("/payment/authorise", new PaymentRequest(UUID.randomUUID()));

    String response = client.toBlocking().retrieve(request);

    assertNotNull(response);
  }
}
