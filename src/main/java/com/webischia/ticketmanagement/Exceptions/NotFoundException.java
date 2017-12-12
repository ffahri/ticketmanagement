package com.webischia.ticketmanagement.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)//404 olduğu zaman mesaj yazdır
public class NotFoundException extends RuntimeException{

    public NotFoundException() {
    }

    public NotFoundException(String s) {
        super(s);
    }
    //todo özel hata sayfaları
    public NotFoundException(String s, Throwable throwable) {
        super(s, throwable);
    }
}
