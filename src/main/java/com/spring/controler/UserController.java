package com.spring.controler;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {


    @GetMapping("/login")
    public String getLogin() {
        return "login";
    }

    //userGetMapping
    @GetMapping(value = "/user")
    public String getUserPage() {
        return "user";
    }

    @GetMapping(value = "/admin")
    public String allUsers() {
        return "admin/allUser";
    }
}
