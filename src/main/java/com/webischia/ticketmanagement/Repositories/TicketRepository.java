package com.webischia.ticketmanagement.Repositories;

import com.webischia.ticketmanagement.Domains.Ticket;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface TicketRepository extends CrudRepository<Ticket,Integer>{

    Optional<Ticket> findById(int id);
    Optional<Ticket> getAllByStatus(Boolean status);
    Optional<Ticket> findByTicketTitle(String title);
}
