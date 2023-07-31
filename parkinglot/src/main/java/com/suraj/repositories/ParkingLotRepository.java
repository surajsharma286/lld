package com.suraj.repositories;

import com.suraj.models.Gate;
import com.suraj.models.ParkingLot;

import java.util.Map;
import java.util.TreeMap;

public class ParkingLotRepository {
    private Map<Long, ParkingLot> parkingLots = new TreeMap<>();

    public ParkingLot getParkingLotForGate(Gate gate){
        for(ParkingLot parkingLot: parkingLots.values()){
            if(parkingLot.getGates().contains(gate))
                return parkingLot;
        }
        return null;
    }
}
