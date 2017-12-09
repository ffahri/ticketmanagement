package com.webischia.ticketmanagement.Services;

import com.webischia.ticketmanagement.Commands.MessageCommand;
import com.webischia.ticketmanagement.Commands.TicketCommand;
import com.webischia.ticketmanagement.Converters.MessageCommandToMessage;
import com.webischia.ticketmanagement.Converters.TicketCommandToTicket;
import com.webischia.ticketmanagement.Converters.TicketToTicketCommand;
import com.webischia.ticketmanagement.Domains.Message;
import com.webischia.ticketmanagement.Domains.Ticket;
import com.webischia.ticketmanagement.Repositories.MessageRepository;
import com.webischia.ticketmanagement.Repositories.TicketRepository;
import com.webischia.ticketmanagement.Repositories.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class TicketServiceImpl implements TicketService{

    private final TicketRepository ticketRepository;
    private final TicketCommandToTicket toTicket;
    private final MessageCommandToMessage toMessage;
    private final MessageRepository messageRepository;
    private final TicketToTicketCommand toTicketCommand;
    private final UserRepository userRepository;

    public TicketServiceImpl(TicketRepository ticketRepository, TicketCommandToTicket toTicket, MessageCommandToMessage toMessage, MessageRepository messageRepository, TicketToTicketCommand toTicketCommand, UserRepository userRepository) {
        this.ticketRepository = ticketRepository;
        this.toTicket = toTicket;
        this.toMessage = toMessage;
        this.messageRepository = messageRepository;
        this.toTicketCommand = toTicketCommand;
        this.userRepository = userRepository;
    }

    @Override
    public Set<Ticket> getTickets() {

        Set<Ticket> tickets = new HashSet<>();
        ticketRepository.findAll().iterator().forEachRemaining(tickets::add); // Java8 LAMBDA <3
        return tickets;
    }

    @Override
    public Ticket findById(int id) {

        Optional<Ticket> findOpt = ticketRepository.findById(id);
        if(!findOpt.isPresent())
        {
            throw new RuntimeException("BULAMADIK"); //todo ileride bunu güzelce siteye ekle
        }

        return findOpt.get();
    }

    @Override
    @Transactional
    public TicketCommand saveTicket(TicketCommand ticketCommand , MessageCommand messageCommand) {
        Ticket tCommand = toTicket.convert(ticketCommand);
        tCommand.setUserTicket(userRepository.findById());
        ticketRepository.save(tCommand);
        Message mCommand = toMessage.convert(messageCommand);
        mCommand.setTicketMessage(this.findById(messageCommand.getId()));
        messageRepository.save(mCommand);

        return toTicketCommand.convert(tCommand);
    }
}
