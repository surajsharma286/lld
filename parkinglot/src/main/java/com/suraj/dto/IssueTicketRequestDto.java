package com.suraj.dto;

import com.suraj.models.VehicleType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class IssueTicketRequestDto {
    private VehicleType vehicleType;
    private String vehicleNumber;
    private String vehicleOwnerName;
    private Long gateId;
}
