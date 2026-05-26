package com.example.salafitnessbackend2;

import com.example.salafitnessbackend2.model.Member;
import com.example.salafitnessbackend2.model.Payment;
import com.example.salafitnessbackend2.repository.PaymentRepository;
import com.example.salafitnessbackend2.service.PaymentService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class PaymentServiceTest {

    @Test
    void testGetAllPayments() {
        PaymentRepository repository = Mockito.mock(PaymentRepository.class);
        PaymentService service = new PaymentService(repository);

        Payment payment = new Payment();
        payment.setAmount(150.0);

        when(repository.findAll()).thenReturn(List.of(payment));

        List<Payment> result = service.getAllPayments();

        assertEquals(1, result.size());
        assertEquals(150.0, result.get(0).getAmount());
    }

    @Test
    void testAddPayment() {
        PaymentRepository repository = Mockito.mock(PaymentRepository.class);
        PaymentService service = new PaymentService(repository);

        Payment payment = new Payment();
        payment.setAmount(200.0);

        when(repository.save(payment)).thenReturn(payment);

        Payment result = service.addPayment(payment);

        assertEquals(200.0, result.getAmount());
    }

    @Test
    void testPaymentHasMember() {
        Payment payment = new Payment();
        Member member = new Member();

        member.setFirstName("Mihai");

        payment.setMember(member);
        payment.setPaymentDate(LocalDate.of(2026, 4, 10));

        assertEquals("Mihai", payment.getMember().getFirstName());
        assertEquals(LocalDate.of(2026, 4, 10), payment.getPaymentDate());
    }
}