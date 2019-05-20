package com.example.es.controller;
import com.example.es.utils.WebUtils;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
public class MainController {
    @GetMapping(value = {"/"})
    public String index(){
        return "/index";
    }
    @GetMapping(value = "/admin")
    public String admin(Principal principal) {
        System.out.println("ADMIN Controller");
        User loginedUser = (User) ((Authentication) principal).getPrincipal();
        String userInfo = WebUtils.toString(loginedUser);
        return userInfo;
    }
    @GetMapping(value = "/user")
    public String user(){
        System.out.println("USER Controller");
        return "/user";
    }
    @GetMapping(value = "/login")
    public String login(){
        return "/login please";
    }
    @GetMapping(value = "/logout")
    public String logout(){
        return "/logout";
    }
    @GetMapping(value = "/useraccountinfo")
    public String useraccountinfo(Principal principal){
        String userName = principal.getName();
        System.out.println("User Name: " + userName);
        User loginedUser = (User) ((Authentication) principal).getPrincipal();
        String userInfo = WebUtils.toString(loginedUser);
        return userInfo;
    }
    @GetMapping("/403")
    public String accessDenied(){
        return "403";
    }
    @GetMapping("/logoutSuccessful")
    public String logoutSuccessful(){
        return "Successful logout";
    }
}
