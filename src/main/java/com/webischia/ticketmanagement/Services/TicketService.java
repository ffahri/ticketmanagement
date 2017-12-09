package com.webischia.ticketmanagement.Services;

import com.webischia.ticketmanagement.Commands.MessageCommand;
import com.webischia.ticketmanagement.Commands.TicketCommand;
import com.webischia.ticketmanagement.Domains.Ticket;

import java.util.Set;

public interface TicketService {
    Set<Ticket> getTickets();

    Ticket findById(int id);
    TicketCommand saveTicket(TicketCommand ticketCommand, MessageCommand messageCommand);
}
