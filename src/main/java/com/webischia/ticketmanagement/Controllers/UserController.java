package com.webischia.ticketmanagement.Controllers;


import com.webischia.ticketmanagement.Repositories.MessageRepository;
import com.webischia.ticketmanagement.Repositories.TicketRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {

    private final TicketRepository ticketRepository;
    private final MessageRepository messageRepository;

    public UserController(TicketRepository ticketRepository, MessageRepository messageRepository) {
        this.ticketRepository = ticketRepository;
        this.messageRepository = messageRepository;
    }

    @RequestMapping("/user/create")
    private String createTicket()
    {

        return "user/create";
    }
    @RequestMapping({"/user","/user/index"})
    private String userDashboard()
    {

        return "user/index";
    }
}
