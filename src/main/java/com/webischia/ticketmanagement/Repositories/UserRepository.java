package com.webischia.ticketmanagement.Repositories;

import com.webischia.ticketmanagement.Domains.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User,Integer>{
    Optional<User> findById(int id);
    Optional<User> findByEmail(String email);
    Optional<User> getAllByAccessLevel();
}
