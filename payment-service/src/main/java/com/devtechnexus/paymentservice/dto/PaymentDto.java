package com.devtechnexus.paymentservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Data Transfer Object for Payment
 * uid - user id
 * oid - order id
 * price - amount payable
 * currency - currency code (USD)
 * method - payment method (paypal)
 * intent - payment intent (sale)
 * description - description of payment, enter order contents here preferably
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class PaymentDto {
    private int oid;
    private String user;
    private double price;
    private String currency;
    private String method;
    private String intent;
    private String description;


}
