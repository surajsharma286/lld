package com.suraj.repositories;

import com.suraj.models.Ticket;

import java.util.Map;
import java.util.TreeMap;

public class TicketRepository {
    private Map<Long,Ticket> tickets = new TreeMap<>();

    private int previousId = 0;
    public Ticket saveTicket(Ticket ticket){
        previousId += 1;
        ticket.setId((long) previousId);
        tickets.put(ticket.getId(), ticket);

        return ticket;
    }
}
