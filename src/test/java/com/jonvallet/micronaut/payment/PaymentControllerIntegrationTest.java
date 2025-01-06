package com.jonvallet.micronaut.payment;

import io.micronaut.http.HttpRequest;
import io.micronaut.http.client.HttpClient;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;


@MicronautTest
public class PaymentControllerIntegrationTest {

  @Inject
  @Client("/")
  HttpClient client;

  ExecutorService executor = Executors.newVirtualThreadPerTaskExecutor();

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

  @Order(3)
  @Test
  public void testMultipleAuthorisePayment() throws Exception {
    List<CompletableFuture<String>> futures = new ArrayList<>();

    for (int i = 0; i < 1000; i++) {
      futures.add(CompletableFuture.supplyAsync(this::execute, executor));
    }

    for (var future : futures) {
      future.get();
    }
  }

  private String execute() {
    HttpRequest<PaymentRequest> request = HttpRequest.POST("/payment/authorise", new PaymentRequest(UUID.randomUUID()));
    System.out.println("Executing request");
    return client.toBlocking().retrieve(request);
  }

}
