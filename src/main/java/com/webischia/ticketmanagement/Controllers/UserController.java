package com.webischia.ticketmanagement.Controllers;


import com.webischia.ticketmanagement.Commands.MessageCommand;
import com.webischia.ticketmanagement.Commands.TicketCommand;
import com.webischia.ticketmanagement.Domains.Message;
import com.webischia.ticketmanagement.Exceptions.NotFoundException;
import com.webischia.ticketmanagement.Repositories.MessageRepository;
import com.webischia.ticketmanagement.Repositories.TicketRepository;
import com.webischia.ticketmanagement.Services.MessageService;
import com.webischia.ticketmanagement.Services.TicketService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {


    private final TicketService ticketService;
    private final MessageService messageService;

    public UserController(TicketService ticketService, MessageService messageService) {
        this.ticketService = ticketService;
        this.messageService = messageService;
    }

    @RequestMapping("/user/create")
    private String createTicket(Model model)
    {

        model.addAttribute("ticket",new TicketCommand());
        model.addAttribute("message",new MessageCommand());
        return "user/create";
    }
    @RequestMapping("/user/show/{id}")
    public String showTicket(@PathVariable int id, Model model)
    {
        model.addAttribute("ticketv",ticketService.findById(id));
        return "user/show";

    }
    @RequestMapping({"/user","/user/index"})
    private String userDashboard()
    {
        return "user/index";
    }

    @PostMapping
    @RequestMapping("/user/add")
    private String addOrUpdate(@ModelAttribute TicketCommand ticketCommand,@ModelAttribute MessageCommand messageCommand)
    {
      //  ticketCommand.getMessages().add(messageCommand);
        if(ticketCommand == null)
            return "";
        TicketCommand ticketC = ticketService.saveTicket(ticketCommand);
        messageService.saveMessage(messageCommand,ticketC.getId());
        return userDashboard();
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
