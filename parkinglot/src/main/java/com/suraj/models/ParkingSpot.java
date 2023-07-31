package com.suraj.models;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
public class ParkingSpot extends BaseModel{
    private List<VehicleType> supportedVehicleTypes;
    private ParkingSpotStatus parkingSpotStatus;
    private ParkingFloor parkingFloor;
    private int spotNumber;
}
