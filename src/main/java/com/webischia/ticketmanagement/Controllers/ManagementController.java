package com.webischia.ticketmanagement.Controllers;

import com.webischia.ticketmanagement.Exceptions.NotFoundException;
import com.webischia.ticketmanagement.Services.MessageService;
import com.webischia.ticketmanagement.Services.TicketService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

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

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(NotFoundException.class)
    private ModelAndView notFound()
    {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("/404");
        return mav;
    }
}
