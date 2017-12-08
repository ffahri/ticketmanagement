package com.webischia.ticketmanagement.Bootstrap;

import com.webischia.ticketmanagement.Domains.Message;
import com.webischia.ticketmanagement.Domains.Ticket;
import com.webischia.ticketmanagement.Domains.User;
import com.webischia.ticketmanagement.Repositories.MessageRepository;
import com.webischia.ticketmanagement.Repositories.TicketRepository;
import com.webischia.ticketmanagement.Repositories.UserRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Component
public class TicketBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private final TicketRepository ticketRepository;
    private final UserRepository userRepository;
    private final MessageRepository messageRepository;

    public TicketBootstrap(TicketRepository ticketRepository, UserRepository userRepository, MessageRepository messageRepository) {
        this.ticketRepository = ticketRepository;
        this.userRepository = userRepository;
        this.messageRepository = messageRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        ticketRepository.saveAll(getTicket());
        messageRepository.saveAll(getMesaj());
    }

    private List<Ticket> getTicket()
    {
        Optional<User> clientOpt = userRepository.findById(1);
        Optional<User> employeeOpt = userRepository.findById(2);
        User musteri = clientOpt.get();
        User calisan = employeeOpt.get();
        List<Ticket> tickets = new ArrayList<>(2);

        Ticket sorun1 = new Ticket();
        sorun1.setStatus(true);
        sorun1.setTicketTitle("SORUUNN 1");
        sorun1.setUserTicket(musteri);

        tickets.add(sorun1);


        return tickets;
    }
    private List<Message> getMesaj()
    {
        Optional<Ticket> ticket1 = ticketRepository.findById(1);
        Ticket ticketR = ticket1.get();
        Message mesaj = new Message();
        mesaj.setMessageContext("bir bir bir");
        Optional<User> clientOpt = userRepository.findById(1);
        Optional<User> employeeOpt = userRepository.findById(2);
        User musteri = clientOpt.get();
        mesaj.setUserMessage(musteri);
        mesaj.setTicketMessage(ticketR);

        List<Message> f = new ArrayList<>(2);
        f.add(mesaj);

        return f;
    }
}
