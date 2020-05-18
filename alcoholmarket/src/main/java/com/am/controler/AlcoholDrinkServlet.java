package com.am.controler;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AlcoholDrinkServlet {

    @RequestMapping(value = "/oneType", method = RequestMethod.GET)
    public String showOneType(ModelMap model) {
        model.addAttribute("alcohol", "fuck off, it's monday, go to the job!");
        return "mainPage";
    }

    @RequestMapping(value = "/mainPage", method = RequestMethod.GET)
    public String mainPage(ModelMap model) {
        model.addAttribute("alcohol", "fuck off, it's monday, go to the job!");
        return "mainPage";
    }
}
