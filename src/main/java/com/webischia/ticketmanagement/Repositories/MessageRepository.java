package com.webischia.ticketmanagement.Repositories;

import com.webischia.ticketmanagement.Domains.Message;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface MessageRepository extends CrudRepository <Message,Long>{

    Optional<Message> findById(long id);
    Optional<Message> findByClientId(int id);
    Optional<Message> findByEmployeeId(int id);
}
