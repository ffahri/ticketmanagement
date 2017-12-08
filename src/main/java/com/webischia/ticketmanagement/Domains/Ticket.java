package com.webischia.ticketmanagement.Domains;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;
@Entity
@Data
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String ticketTitle;

    @OneToMany(mappedBy = "ticketMessage")
    private Set<Message> messages;

    @ManyToOne
    @JoinColumn(name = "user_id",nullable = false)
    private User userTicket;

    private boolean status;

    @Temporal(TemporalType.TIMESTAMP) //todo kontrol edelim elle girerken filan data.sql ile olmadı
    private Date creationDate = new Date();


}
