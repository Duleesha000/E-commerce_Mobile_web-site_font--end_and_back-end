package com.devtechnexus.paymentservice.service;

import com.devtechnexus.paymentservice.dto.PaymentDto;
import com.devtechnexus.paymentservice.model.PaymentRecord;
import com.devtechnexus.paymentservice.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Service
public class LedgerService {

    @Autowired
    private PaymentRepository paymentRepository;

    /**
     * run when payment is CREATED
     */
    public void createLedgerEntry(String id, PaymentDto payment) {


        paymentRepository.save(new PaymentRecord(
                payment.getUser(),
                payment.getOid(),
                payment.getPrice(),
                Timestamp.valueOf(LocalDateTime.now()),
                "PENDING",
                id,
                payment.getCurrency(),
                payment.getDescription()));
    }

    /**
     * run when payment is PAID
     * @returns int id of the order
     */
    public int successLedgerEntry(String paymentId) {
        PaymentRecord paymentRecord = paymentRepository.findByPaymentId(paymentId);
        paymentRecord.setStatus("COMPLETED");
        paymentRecord.setPaymentId(paymentId);
        paymentRepository.save(paymentRecord);
        return paymentRecord.getOrderId();
    }

    public void cancelLedgerEntry(String paymentId) {
        PaymentRecord paymentRecord = paymentRepository.findByPaymentId(paymentId);
        paymentRecord.setStatus("CANCELLED");
        paymentRepository.save(paymentRecord);
    }

}
