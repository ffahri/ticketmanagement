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
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
@Slf4j
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
        log.debug("TicketService --- Veri çekildi getTickets");
        return tickets;

    }

    @Override
    public Ticket findById(int id) {

        Optional<Ticket> findOpt = ticketRepository.findById(id);
        if(!findOpt.isPresent())
        {
            throw new RuntimeException("BULAMADIK = " + id); //todo ileride bunu güzelce siteye ekle
        }

        return findOpt.get();
    }

    @Override
    @Transactional
    public TicketCommand saveTicket(TicketCommand ticketCommand) {
        Ticket tCommand = new Ticket();
        tCommand.setStatus(ticketCommand.isStatus());
        tCommand.setTicketTitle(ticketCommand.getTicketTitle());
        tCommand.setCreationDate(ticketCommand.getCreationDate());
        tCommand.setId(ticketCommand.getId());
        tCommand.setUserTicket(userRepository.findById(1).get());
        Ticket after = ticketRepository.save(tCommand);
        log.debug("TicketService --- Ticket oluşturuldu  -> TICKET ID = " + after.getId());
        return toTicketCommand.convert(after);
    }
}
