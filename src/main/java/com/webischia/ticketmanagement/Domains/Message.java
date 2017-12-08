package com.webischia.ticketmanagement.Domains;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@EqualsAndHashCode(exclude = {"ticketMessage","userMessage"})
@Data
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String messageContext;

    @ManyToOne
    @JoinColumn(name="ticket_id" , nullable = false)// bir mesaj yalnız ve yalnız bir kullanıcıya ait olabilir.
    private Ticket ticketMessage;

    @ManyToOne
    @JoinColumn(name="user_id" , nullable = false)
    private User userMessage;

    @Temporal(TemporalType.TIMESTAMP) //todo kontrol edelim elle girerken filan data.sql ile olmadı
    private Date creationDate = new Date();



}
