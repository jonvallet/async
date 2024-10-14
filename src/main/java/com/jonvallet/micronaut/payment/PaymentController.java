package com.jonvallet.micronaut.payment;

import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Post;
import jakarta.inject.Inject;

@Controller
public class PaymentController {

  @Inject
  private PaymentService accountService;

  @Post("/payment/authorise")
  public String authorise(@Body PaymentRequest paymentRequest) {
    return accountService.authorisePayment(paymentRequest.paymentId());
  }

  @Get("payment/status")
  public String status() {
    return "UP";
  }
}
