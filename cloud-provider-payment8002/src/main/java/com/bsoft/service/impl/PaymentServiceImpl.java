package com.bsoft.service.impl;

import com.bsoft.dao.PaymentDao;
import com.bsoft.entity.Payment;
import com.bsoft.service.PaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Resource
    private PaymentDao paymentDao;

    @Override
    public int create(Payment payment) {
        return paymentDao.create(payment);
    }

    @Override
    public Payment getPaymentById(Long id) {
        return paymentDao.getPaymentById(id);
    }

    @Override
    public int update(Payment payment) {
        return paymentDao.update(payment);
    }

    @Override
    public List<Payment> getPayment() {
        return paymentDao.getPayment();
    }
}