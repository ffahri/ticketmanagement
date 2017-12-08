package com.webischia.ticketmanagement.Domains;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
public class AccessLevel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String description;

    @Temporal(TemporalType.TIMESTAMP) //todo kontrol edelim elle girerken filan data.sql ile olmadı
    private Date creationDate = new Date();

    @OneToOne(mappedBy = "accessLevel")
    private User useraccess;
}
