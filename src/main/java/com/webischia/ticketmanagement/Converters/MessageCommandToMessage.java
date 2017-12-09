package com.webischia.ticketmanagement.Converters;

import com.webischia.ticketmanagement.Commands.MessageCommand;
import com.webischia.ticketmanagement.Domains.Message;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class MessageCommandToMessage implements Converter<MessageCommand,Message> {


   /* private final TicketCommandToTicket toTicket;

    public MessageCommandToMessage(TicketCommandToTicket toTicket) {
        this.toTicket = toTicket;
    }*/

    @Nullable
    @Override
    @Synchronized
    public Message convert(MessageCommand messageCommand) {
        if(messageCommand == null) {
            return null;
        }
        Message message = new Message();
        //message.setTicketMessage(toTicket.convert(messageCommand.getTicketMessage()));
        message.setUserMessage(messageCommand.getUserMessage());
        message.setId(messageCommand.getId());
        message.setCreationDate(messageCommand.getCreationDate());
        message.setMessageContext(messageCommand.getMessageContext());
        return message;
    }
}
