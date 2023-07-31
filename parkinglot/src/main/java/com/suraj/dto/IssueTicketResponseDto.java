package com.suraj.dto;

import com.suraj.models.Ticket;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class IssueTicketResponseDto {
    private ResponseStatus responseStatus;
    private Ticket ticket;
    private String failureReason;

}
