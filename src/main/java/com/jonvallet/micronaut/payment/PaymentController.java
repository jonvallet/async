package com.jonvallet.micronaut.payment;

import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Post;
import io.micronaut.scheduling.TaskExecutors;
import io.micronaut.scheduling.annotation.ExecuteOn;
import jakarta.inject.Inject;

@Controller
public class PaymentController {

  @Inject
  private PaymentService accountService;

  @Post("/payment/authorise")
  @ExecuteOn(TaskExecutors.VIRTUAL)
  public String authorise(@Body PaymentRequest paymentRequest) {
    return accountService.authorisePayment(paymentRequest.paymentId());
  }

  @Get("payment/status")
  public String status() {
    return "UP";
  }
}
