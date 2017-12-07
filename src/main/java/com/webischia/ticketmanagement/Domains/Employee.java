package com.webischia.ticketmanagement.Domains;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.validator.constraints.UniqueElements;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@EqualsAndHashCode(exclude = {"client","employeeSet"})
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private String surname;
    //@UniqueElements eklenecek
    private String email;
    @ManyToMany(mappedBy = "employeeSet")
    private Set<Message> messages = new HashSet<>();
}
