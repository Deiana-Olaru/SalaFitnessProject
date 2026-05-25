package com.example.salafitnessbackend2.service;

import com.example.salafitnessbackend2.model.Payment;
import com.example.salafitnessbackend2.repository.PaymentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentService {

    private final PaymentRepository paymentRepository;

    public PaymentService(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    public List<Payment> getAllPayments() {
        return paymentRepository.findAll();
    }

    public Payment addPayment(Payment payment) {
        return paymentRepository.save(payment);
    }

    public Payment updatePayment(Long id, Payment updatedPayment) {
        Payment payment = paymentRepository.findById(id).orElseThrow();

        payment.setAmount(updatedPayment.getAmount());
        payment.setPaymentDate(updatedPayment.getPaymentDate());
        payment.setMember(updatedPayment.getMember());

        return paymentRepository.save(payment);
    }

    public void deletePayment(Long id) {
        paymentRepository.deleteById(id);
    }
}