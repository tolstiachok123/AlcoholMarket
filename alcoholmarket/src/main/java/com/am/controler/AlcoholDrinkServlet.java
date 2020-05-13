package com.am.controler;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServlet;

@Controller
public class AlcoholDrinkServlet extends HttpServlet {

    @RequestMapping(value = "/oneType", method = RequestMethod.GET)
    public String showLiqueurs(ModelMap model){
        model.addAttribute("alcohol", "fuck off, it's monday, go to the job!");
        return "selection";
    }

}
