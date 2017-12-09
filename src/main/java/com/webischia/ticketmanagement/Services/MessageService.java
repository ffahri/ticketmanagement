package com.webischia.ticketmanagement.Services;

import com.webischia.ticketmanagement.Commands.MessageCommand;

public interface MessageService {
    void saveMessage(MessageCommand messageCommand,int id);
}
