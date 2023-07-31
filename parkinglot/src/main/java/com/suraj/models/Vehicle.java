package com.suraj.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Vehicle extends BaseModel{
    private String number;
    private VehicleType vehicleType;
    private String ownerName;
}
