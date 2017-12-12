package com.webischia.ticketmanagement.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {

    @RequestMapping("/giris")
    private String redirectLogin()
    {
        return "/giris/login";
    }
}
