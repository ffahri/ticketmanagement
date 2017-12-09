package com.webischia.ticketmanagement.Services;

import com.webischia.ticketmanagement.Commands.MessageCommand;
import com.webischia.ticketmanagement.Converters.MessageCommandToMessage;
import com.webischia.ticketmanagement.Domains.Message;
import com.webischia.ticketmanagement.Repositories.MessageRepository;
import com.webischia.ticketmanagement.Repositories.TicketRepository;
import com.webischia.ticketmanagement.Repositories.UserRepository;
import lombok.Synchronized;
import lombok.extern.slf4j.Slf4j;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class MessageServiceImpl implements MessageService {

    private final MessageCommandToMessage toMessage;
    private final TicketService ticketService;
    private final UserRepository userRepository;
    private final MessageRepository messageRepository;

    public MessageServiceImpl(MessageCommandToMessage toMessage, TicketService ticketService, UserRepository userRepository, MessageRepository messageRepository) {
        this.toMessage = toMessage;
        this.ticketService = ticketService;
        this.userRepository = userRepository;
        this.messageRepository = messageRepository;
    }

    @Override
    @Synchronized
    @Nullable
    public void saveMessage(MessageCommand messageCommand,int id) {
        if(messageCommand==null){

        }
        Message mesaj = new Message();
        mesaj.setTicketMessage(ticketService.findById(id));
        mesaj.setMessageContext(messageCommand.getMessageContext());
        mesaj.setCreationDate(messageCommand.getCreationDate());
        mesaj.setUserMessage(userRepository.findById(1).get());
        messageRepository.save(mesaj);
    }

    public void deleteById(int id)
    {
        messageRepository.deleteById(id);
        log.debug("Message Service --- Silme başarılı");
    }
}
