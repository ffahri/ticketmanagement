package com.webischia.ticketmanagement.Converters;

import com.webischia.ticketmanagement.Commands.TicketCommand;
import com.webischia.ticketmanagement.Domains.Ticket;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class TicketToTicketCommand implements Converter<Ticket,TicketCommand> {

    private final MessageToMessageCommand toMessageCommand;

    public TicketToTicketCommand(MessageToMessageCommand toMessageCommand) {
        this.toMessageCommand = toMessageCommand;
    }

    @Nullable
    @Override
    @Synchronized
    public TicketCommand convert(Ticket ticket) {
        if(ticket == null) {
            return null;
        }
        TicketCommand ticketCommand = new TicketCommand();
        ticketCommand.setCreationDate(ticket.getCreationDate());
        ticketCommand.setId(ticket.getId());
        ticketCommand.setStatus(ticket.isStatus());
        ticketCommand.setTicketTitle(ticket.getTicketTitle());
        ticketCommand.setUserTicket(ticket.getUserTicket());
/*
        if(ticket.getMessages() != null && ticket.getMessages().size() > 0)
        {
            ticket.getMessages().forEach(message -> ticketCommand.getMessages().add(toMessageCommand.convert(message)));

        }*/
        return ticketCommand;
    }
}
