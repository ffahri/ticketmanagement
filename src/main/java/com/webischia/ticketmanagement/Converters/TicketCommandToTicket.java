package com.webischia.ticketmanagement.Converters;

import com.webischia.ticketmanagement.Commands.TicketCommand;
import com.webischia.ticketmanagement.Domains.Ticket;
import lombok.Synchronized;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class TicketCommandToTicket implements Converter<TicketCommand,Ticket> {

    @Autowired
    private final MessageCommandToMessage toMessage;

    public TicketCommandToTicket(MessageCommandToMessage toMessage) {
        this.toMessage = toMessage;
    }

    @Nullable
    @Override
    @Synchronized
    public Ticket convert(TicketCommand ticketCommand) {

        if(ticketCommand == null)
        {
            return null;
        }

        final Ticket ticket = new Ticket();
        ticket.setTicketTitle(ticketCommand.getTicketTitle());
        ticket.setUserTicket(ticket.getUserTicket());
        ticket.setStatus(ticketCommand.isStatus());
        ticket.setId(ticketCommand.getId());
        ticket.setCreationDate(ticketCommand.getCreationDate());

        /*if(ticketCommand.getMessages() != null && ticketCommand.getMessages().size() > 0 )
        {
            ticketCommand.getMessages().forEach(message -> ticket.getMessages().add(toMessage.convert(message)));
        }
*/
        return ticket;
    }
}
