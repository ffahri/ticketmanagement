package com.webischia.ticketmanagement.Domains;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private String surname;
    private String email;
    private String phone;

    @Temporal(TemporalType.TIMESTAMP) //todo kontrol edelim elle girerken filan data.sql ile olmadı
    private Date creationDate = new Date();

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "access_id", nullable = false)
    private AccessLevel accessLevel;

    @OneToMany(mappedBy = "userTicket")
    private Set<Ticket> ticketSet;

    @OneToMany(mappedBy = "userMessage")
    private Set<Message> messages;
}
