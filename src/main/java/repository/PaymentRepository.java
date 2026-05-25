package com.example.salafitnessbackend2.repository;

import com.example.salafitnessbackend2.model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
}