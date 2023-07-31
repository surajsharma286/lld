package com.suraj.services;

import com.suraj.exceptions.GateNotfoundException;
import com.suraj.factories.SpotAssignmentStrategyFactory;
import com.suraj.models.*;
import com.suraj.repositories.GateRepository;
import com.suraj.repositories.ParkingLotRepository;
import com.suraj.repositories.TicketRepository;
import com.suraj.repositories.VehicleRepository;
import com.suraj.strategies.SpotAssignmentStrategy;

import java.util.Date;
import java.util.Optional;

public class TicketService {
    private GateRepository gateRepository;

    private VehicleRepository vehicleRepository;

    private SpotAssignmentStrategy spotAssignmentStrategy;

    private ParkingLotRepository parkingLotRepository;

    private TicketRepository ticketRepository;

    public TicketService(GateRepository gateRepository,
                         VehicleRepository vehicleRepository,
                         ParkingLotRepository parkingLotRepository,
                         TicketRepository ticketRepository){
        this.gateRepository = gateRepository;
        this.vehicleRepository = vehicleRepository;
        this.parkingLotRepository = parkingLotRepository;
        this.ticketRepository = ticketRepository;
    }
    public Ticket issueTicket(VehicleType vehicleType,
                              String vehicleNumber,
                              String vehicleOwnerName,
                              Long gateId) {
        // 1. Create a Ticket Object
        // 2. Assign Spot
        // 3. return ticket
        Ticket ticket = new Ticket();
        ticket.setEntryTime(new Date());

        Optional<Gate> optionalGate = gateRepository.findGateById(gateId);
        if(optionalGate.isEmpty()){
            throw new GateNotfoundException();
        }
        Gate gate = optionalGate.get();
        ticket.setGeneratedAt(gate);
        ticket.setGeneratedBy(gate.getCurrentOperator());

        // Check if the vehicle in DB
        // 1. Yes
        // -- get Vehicle from DB
        // -- put in the Ticket Object
        // 2. No
        // -- Create a new Vehicle
        // -- save it in DB
        // put in the ticket
        Vehicle savedVehicle;
        Optional<Vehicle> optionalVehicle = vehicleRepository
                .getVehicleByNumber(vehicleNumber);
        if(optionalGate.isEmpty()){
            Vehicle vehicle = new Vehicle();
            vehicle.setVehicleType(vehicleType);
            vehicle.setNumber(vehicleNumber);
            vehicle.setOwnerName(vehicleOwnerName);

            savedVehicle = vehicleRepository.saveVehicle(vehicle);
        }else{
            savedVehicle = optionalVehicle.get();
        }
        ticket.setVehicle(savedVehicle);

        ticket.setAssignedSpot(spotAssignmentStrategy.getParkingSpot(gate, vehicleType));

        SpotAssignmentStrategyType assignmentStrategyType = parkingLotRepository
                .getParkingLotForGate(gate)
                .getSpotAssignmentStrategyType();

        SpotAssignmentStrategy spotAssignmentStrategy = SpotAssignmentStrategyFactory
                .getSpotAssignmentStrategy(assignmentStrategyType);

        ticket.setAssignedSpot(spotAssignmentStrategy.getParkingSpot(gate,vehicleType));
        ticket.setNumber("Ticket - ");

        return ticketRepository.saveTicket(ticket);
    }
}
