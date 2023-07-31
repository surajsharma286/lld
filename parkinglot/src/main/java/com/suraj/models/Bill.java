package com.suraj.models;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
public class Bill extends BaseModel{
    private Date exitTime;
    private Ticket ticket;
    private Gate gate;
    private int amount;
    private Operator generatedBy;
    private List<Payment> payments;
    private FeesCalculatorStrategyType feesCalculatorStrategyType;
}
