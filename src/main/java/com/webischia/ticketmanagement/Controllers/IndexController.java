package com.webischia.ticketmanagement.Controllers;

import com.webischia.ticketmanagement.Exceptions.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController {

    @RequestMapping({"","/","/index"})
    public String getIndex()
    {

        return "index";//file /resources/templates/index.html
    }
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(NotFoundException.class)
    private ModelAndView notFound()
    {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("/404");
        return mav;
    }

}
