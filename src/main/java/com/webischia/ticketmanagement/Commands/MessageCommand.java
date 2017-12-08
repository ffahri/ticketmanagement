package com.webischia.ticketmanagement.Commands;

import com.webischia.ticketmanagement.Domains.Ticket;
import com.webischia.ticketmanagement.Domains.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class MessageCommand {

    private int id;
    private String messageContext;
    private Ticket ticketMessage;
    private User userMessage;
    private Date creationDate = new Date();

}
