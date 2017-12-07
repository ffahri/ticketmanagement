package com.webischia.ticketmanagement.Domains;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@EqualsAndHashCode(exclude = {"messages"})
public class Client {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private String surname;

    private String email;


    @ManyToOne// ????? todo
    private Set<Message> messages = new HashSet<>();


}
