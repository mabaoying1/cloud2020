package com.bsoft.dao;

import com.bsoft.entity.Payment;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PaymentDao {
     int create(Payment payment);
     Payment getPaymentById(@Param("id") Long id);
     int update(Payment payment);

    List<Payment> getPayment();
}
