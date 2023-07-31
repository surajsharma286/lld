package com.suraj.strategies;

import com.suraj.models.Gate;
import com.suraj.models.ParkingSpot;
import com.suraj.models.SpotAssignmentStrategyType;
import com.suraj.models.VehicleType;

public class RandomSpotAssignmentStrategy implements SpotAssignmentStrategy {
    @Override
    public ParkingSpot getParkingSpot(Gate gate, VehicleType vehicleType) {
        return null;
    }
}
