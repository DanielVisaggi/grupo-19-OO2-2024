package com.unla.grupo19.controllers;

import com.unla.grupo19.helpers.ViewHelper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/adm")
public class AdminController {
    @GetMapping("/panel")
    public String adminPanel(){
        return ViewHelper.ADMIN_PAGE;
    }
}
