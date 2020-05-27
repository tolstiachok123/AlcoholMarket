package com.am.controler;

import com.am.dao.UserDao;
import com.am.model.User;
import com.am.validator.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AlcoholDrinkServlet {

    @Autowired
    private UserDao userDao;

    @Autowired
    private UserValidator validator;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login() {
        return "login";
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String register(Model model) {
        User newUser = new User();
        model.addAttribute("newUser", newUser);
        return "registration";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String doRegister(Model model, User newUser, BindingResult result){
        validator.validate(newUser, result);
        if (result.hasErrors()) {
            model.addAttribute("error", result.getAllErrors());
            return "../error";
        }
        userDao.addUser(newUser);
        return "mainPage";
    }

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
