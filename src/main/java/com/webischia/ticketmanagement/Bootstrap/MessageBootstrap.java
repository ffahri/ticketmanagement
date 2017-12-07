package com.webischia.ticketmanagement.Bootstrap;

import com.webischia.ticketmanagement.Domains.Message;
import com.webischia.ticketmanagement.Repositories.MessageRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Component
public class MessageBootstrap implements ApplicationListener<ContextRefreshedEvent>{

    private final MessageRepository messageRepository;

    //Dependency Injection by Constructor
    public MessageBootstrap(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    @Override
    @Transactional
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {

        //messageRepository.save(makeMessage());
    }

    private List<Message> makeMessage()
    {
        //todo kullanıcıidyi al optional ile employee id al
        //todo message oluştur bunları gir ve gönder -- test -- bootstrap

      List<Message> messageList = new ArrayList<>(2);


        return messageList;
    }
}
