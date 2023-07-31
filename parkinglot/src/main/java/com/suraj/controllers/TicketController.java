package com.suraj.controllers;

import com.suraj.dto.IssueTicketRequestDto;
import com.suraj.dto.IssueTicketResponseDto;
import com.suraj.dto.ResponseStatus;
import com.suraj.models.Ticket;
import com.suraj.services.TicketService;

public class TicketController {

    private TicketService ticketService;

    public TicketController(TicketService ticketService){
        this.ticketService = ticketService;
    }

    public IssueTicketResponseDto issueTicket(IssueTicketRequestDto issueTicketRequestDto){
        IssueTicketResponseDto responseDto = null;
        try {
            Ticket ticket = ticketService.issueTicket(issueTicketRequestDto.getVehicleType(),
                    issueTicketRequestDto.getVehicleNumber(),
                    issueTicketRequestDto.getVehicleOwnerName(),
                    issueTicketRequestDto.getGateId()
            );
            responseDto = new IssueTicketResponseDto();
            responseDto.setTicket(ticket);
            responseDto.setResponseStatus(ResponseStatus.SUCCESS);
        }catch (Exception e){
            responseDto.setResponseStatus(ResponseStatus.FAIL);
            responseDto.setFailureReason(e.getMessage());
            return responseDto;
        }

        return responseDto;
    }
}
