package com.webischia.ticketmanagement.Commands;

import com.webischia.ticketmanagement.Domains.AccessLevel;
import com.webischia.ticketmanagement.Domains.Message;
import com.webischia.ticketmanagement.Domains.Ticket;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
public class UserCommand {

    private int id;
    private String name;
    private String surname;
    private String email;
    private String phone;
    private Date creationDate = new Date();
    private AccessLevel accessLevel;
    private Set<Ticket> ticketSet = new HashSet<>();
    private Set<Message> messages = new HashSet<>();
}
