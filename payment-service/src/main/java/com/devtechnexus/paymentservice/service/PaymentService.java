package com.devtechnexus.paymentservice.service;

import com.paypal.api.payments.*;
import com.paypal.base.rest.APIContext;
import com.paypal.base.rest.PayPalRESTException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

@Service
public class PaymentService {

    @Autowired
    private APIContext apiContext;


    /**
     * createPayment
     * @param total total amount payable
     * @param currency currency code (USD)
     * @param method payment method, PayPal mostly, scalable to other PSPs
     * @param intent payment intent, sale usually
     * @param description description of payment, enter order contents here preferably
     * @param cancelUrl cancel url for PayPal to redirect to on successful transaction
     * @param successUrl success url for PayPal to redirect to on successful transaction
     * @return Payment object
     * @throws PayPalRESTException
     */
    public Payment createPayment(Double total,
                                 String currency,
                                 String method,
                                 String intent,
                                 String description,
                                 String cancelUrl,
                                 String successUrl) throws PayPalRESTException {

        Amount amount = new Amount();
        amount.setCurrency(currency);
        double AccurateTotal = new BigDecimal(total).setScale(2, RoundingMode.HALF_UP).doubleValue();
        amount.setTotal(String.format("%.2f", AccurateTotal));

        Transaction transaction = new Transaction();
        transaction.setDescription(description);
        transaction.setAmount(amount);

        List<Transaction> transactionList = new ArrayList<>();
        transactionList.add(transaction);

        Payer payer = new Payer();
        payer.setPaymentMethod(method);

        Payment payment = new Payment();
        payment.setIntent(intent);
        payment.setPayer(payer);
        payment.setTransactions(transactionList);

        RedirectUrls urls = new RedirectUrls();
        urls.setCancelUrl(cancelUrl);
        urls.setReturnUrl(successUrl);
        payment.setRedirectUrls(urls);

        System.out.println("Payment created: ");
        return payment.create(apiContext);
    }

    public Payment executePayment(String paymentId, String payerId) throws PayPalRESTException {
        Payment payment = new Payment();
        payment.setId(paymentId);
        PaymentExecution paymentExecutor = new PaymentExecution();
        paymentExecutor.setPayerId(payerId);
        return payment.execute(apiContext, paymentExecutor);


    }


}
