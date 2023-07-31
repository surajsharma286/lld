package com.suraj.strategies;

import com.suraj.models.Gate;
import com.suraj.models.ParkingSpot;
import com.suraj.models.VehicleType;

public interface SpotAssignmentStrategy {
    public ParkingSpot getParkingSpot(Gate gate, VehicleType vehicleType);
}
