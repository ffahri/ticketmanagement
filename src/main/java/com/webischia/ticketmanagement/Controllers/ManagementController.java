package com.webischia.ticketmanagement.Controllers;

import com.webischia.ticketmanagement.Services.MessageService;
import com.webischia.ticketmanagement.Services.TicketService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ManagementController {

    private final TicketService ticketService;

    public ManagementController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    @RequestMapping({"/management","/management/index"})
    public String getIndex(Model model)
    {
        model.addAttribute("tickets",ticketService.getTickets());

        return "management/index";
    }
    @RequestMapping("/management/show/{id}")
    public String showTicket(@PathVariable int id, Model model)
    {
        model.addAttribute("ticketv",ticketService.findById(id));
        return "management/show";

    }
}
