package com.webischia.ticketmanagement.Domains;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@EqualsAndHashCode(exclude = {"client","employeeSet"})
@Data
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String messageTitle;
    private String messageContext;
    /*
    private DATETIME zaman
     */

    private boolean state; // true açık mesaj , false işlem tamamlanmış mesaj

    @ManyToOne // bir mesaj yalnız ve yalnız bir kullanıcıya ait olabilir.
    // sorun -> cevap -> sorun2 -> cevap 2 todo
    private Client client;

    @ManyToMany//bir mesajın birden çok cevaplayanı ve bir cevaplayanın birden çok mesajı olabilir
    private Set<Employee> employeeSet = new HashSet<>(); //hashset çünkü null olmasın :))



}
