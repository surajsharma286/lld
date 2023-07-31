package com.suraj.models;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class Ticket extends BaseModel{
    private String number;
    private Date entryTime;
    private Vehicle vehicle;
    private ParkingSpot assignedSpot;
    private Operator generatedBy;
    private Gate generatedAt;
}
