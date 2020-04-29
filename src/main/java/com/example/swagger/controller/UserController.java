package com.example.swagger.controller;

import com.example.swagger.pojo.Company;
import com.example.swagger.pojo.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lenny
 * @since 2020/4/23 8:25 PM
 */
@RestController
public class UserController {

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public User getUser(){
        Company company = new Company("alibaba","China");
        User user = new User("lenny", 18, company);
        return user;
    }
}
