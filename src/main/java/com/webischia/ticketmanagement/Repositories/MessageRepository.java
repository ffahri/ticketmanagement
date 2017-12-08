package com.webischia.ticketmanagement.Repositories;

import com.webischia.ticketmanagement.Domains.Message;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface MessageRepository extends CrudRepository <Message,Integer> {

    Optional<Message> findById(int id);
    Optional<Message> findByUserMessage(int id);
    Optional<Message> findByTicketMessage(int id);
    Optional<Message> findByMessageContext(String context); //searching by messagecontext WHERE IS THE PRIVACY ???
}
