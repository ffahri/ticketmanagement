package com.webischia.ticketmanagement.Converters;

import com.webischia.ticketmanagement.Commands.MessageCommand;
import com.webischia.ticketmanagement.Domains.Message;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class MessageToMessageCommand implements Converter<Message,MessageCommand> {
  //  private final TicketToTicketCommand toTicketCommand;

    /*public MessageToMessageCommand(TicketToTicketCommand toTicketCommand) {
        this.toTicketCommand = toTicketCommand;
    }
*/
    @Nullable
    @Override
    public MessageCommand convert(Message message) {
        if(message == null) {
            return null;
        }
        MessageCommand messageCommand = new MessageCommand();
        messageCommand.setId(message.getId());
        messageCommand.setCreationDate(message.getCreationDate());
        messageCommand.setMessageContext(message.getMessageContext());
        messageCommand.setUserMessage(message.getUserMessage());
        return messageCommand;
    }
}
