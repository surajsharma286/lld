package com.suraj.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Gate extends BaseModel{
  private GateType gateType;
  private int gateNumber;
  private Operator currentOperator;
  private GateStatus gateStatus;
}
