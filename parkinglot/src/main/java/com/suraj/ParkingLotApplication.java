package com.suraj;

import com.suraj.controllers.TicketController;
import com.suraj.repositories.GateRepository;
import com.suraj.repositories.ParkingLotRepository;
import com.suraj.repositories.TicketRepository;
import com.suraj.repositories.VehicleRepository;
import com.suraj.services.TicketService;

public class ParkingLotApplication {
    public static void main(String[] args) {
        System.out.println("*********************** Starting the Parking Lot App ***********************");
        GateRepository gateRepository = new GateRepository();
        ParkingLotRepository parkingLotRepository = new ParkingLotRepository();
        TicketRepository ticketRepository = new TicketRepository();
        VehicleRepository vehicleRepository = new VehicleRepository();

        TicketService ticketService = new TicketService(gateRepository,
                vehicleRepository,
                parkingLotRepository,
                ticketRepository);

        TicketController ticketController = new TicketController(
                ticketService);

        System.out.println("*********************** Parking Lot App Initialized ***********************");


    }
}
