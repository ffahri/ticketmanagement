package com.webischia.ticketmanagement.Services;

import com.webischia.ticketmanagement.Domains.Ticket;

import java.util.Set;

public interface TicketService {
    Set<Ticket> getTickets();

    Ticket findById(int id);

}
