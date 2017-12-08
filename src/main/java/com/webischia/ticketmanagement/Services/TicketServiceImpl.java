package com.webischia.ticketmanagement.Services;

import com.webischia.ticketmanagement.Domains.Ticket;
import com.webischia.ticketmanagement.Repositories.TicketRepository;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class TicketServiceImpl implements TicketService{

    private final TicketRepository ticketRepository;

    public TicketServiceImpl(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
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
}
