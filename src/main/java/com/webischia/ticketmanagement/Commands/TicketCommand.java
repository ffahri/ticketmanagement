package com.webischia.ticketmanagement.Commands;

import com.webischia.ticketmanagement.Domains.Message;
import com.webischia.ticketmanagement.Domains.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
public class TicketCommand {

    private int id;
    private String ticketTitle;
    private Set<MessageCommand> messages = new HashSet<>();
    private User userTicket;
    private boolean status;
    private Date creationDate = new Date();
}
