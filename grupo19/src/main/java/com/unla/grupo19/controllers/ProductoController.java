package com.unla.grupo19.controllers;


import com.unla.grupo19.dto.StockEstadoProductosDTO;
import com.unla.grupo19.entities.Producto;

import com.unla.grupo19.entities.Stock;
import com.unla.grupo19.entities.User;
import com.unla.grupo19.helpers.ViewHelper;
import com.unla.grupo19.services.implementation.ProductoService;
import com.unla.grupo19.services.implementation.StockService;
import com.unla.grupo19.services.implementation.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/producto")

public class ProductoController {

    @Autowired
    private ProductoService service;

    @Autowired
    private StockService stockService;

    @Autowired
    private UserService userService;

    @GetMapping("/{id}")
    public String getById(@PathVariable(name="id")int id, Model model) {

        Producto producto = service.findById(id);
        model.addAttribute("producto", producto);

        return "producto/getById.html";
    }

    @GetMapping("/estado")
    public ModelAndView estadoPage(){
        ModelAndView mav = new ModelAndView(ViewHelper.ESTADO_PRODUCTOS_PAGE);
        User user = userService.findByUsernameQuery(SecurityContextHolder.getContext().getAuthentication().getName());
        List<StockEstadoProductosDTO> stocks = stockService.stocksToStockEstadoProductosDTO(stockService.findAll());
        mav.addObject("isAdmin", userService.isAdmin(user));
        mav.addObject("stocks", stocks);
        return mav;
    }

}
