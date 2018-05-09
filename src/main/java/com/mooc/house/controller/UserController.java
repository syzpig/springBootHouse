package com.mooc.house.controller;

import com.mooc.house.model.User;
import com.mooc.house.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("msg")
    public List<User> accountsRegister() {
        return userService.getUsers();
    }

    @RequestMapping("index")
    public String index() {
        return "/homepage/index";
    }
}
