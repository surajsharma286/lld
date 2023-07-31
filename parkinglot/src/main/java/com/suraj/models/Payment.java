package com.suraj.models;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
@Getter
@Setter
public class Payment extends BaseModel{
    private PaymentMode paymentMode;
    private int amount;
    private Date time;
    private PaymentStatus paymentStatus;
    private String referenceNumber;
}
