package com.bsoft.service;

import com.bsoft.entity.Payment;

import java.util.List;

public interface PaymentService {
     int create(Payment payment);
     Payment getPaymentById(Long id);
    int update(Payment payment);

    List<Payment> getPayment();
}
