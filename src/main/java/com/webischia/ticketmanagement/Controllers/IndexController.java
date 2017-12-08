package com.webischia.ticketmanagement.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

    @RequestMapping({"","/","/index"})
    public String getIndex()
    {

        return "index";//file /resources/templates/index.html
    }

}
