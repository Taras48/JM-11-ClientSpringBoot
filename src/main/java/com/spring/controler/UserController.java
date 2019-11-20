package com.spring.controler;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {


    @GetMapping("/login")
    public ModelAndView getLogin(ModelAndView modelAndView) {
        modelAndView.setViewName("login");
        return modelAndView;
    }

    //userGetMapping
    @GetMapping(value = "/user")
    public ModelAndView getUserPage(ModelAndView modelAndView) {
        modelAndView.setViewName("user");
        return modelAndView;
    }

    @GetMapping(value = "/admin")
    public ModelAndView allUsers(ModelAndView modelAndView) {
        modelAndView.setViewName("admin/allUser");
        return modelAndView;
    }
}
