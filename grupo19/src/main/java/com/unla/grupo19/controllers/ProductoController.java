package com.unla.grupo19.controllers;


import com.unla.grupo19.entities.Producto;

import com.unla.grupo19.helpers.ViewHelper;
import com.unla.grupo19.services.implementation.ProductoService;
import com.unla.grupo19.services.implementation.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/producto")

public class ProductoController {

    @Autowired
    private ProductoService service;

    @Autowired
    private StockService stockService;

    @GetMapping("/{id}")
    public String getById(@PathVariable(name="id")int id, Model model) {

        Producto producto = service.findById(id);
        model.addAttribute("producto", producto);

        return "producto/getById.html";
    }

    @GetMapping("/estado")
    public ModelAndView estadoPage(){
        ModelAndView mav = new ModelAndView(ViewHelper.ESTADO_PRODUCTOS_PAGE);
        mav.addObject("stocks", stockService.findAll());
        return mav;
    }

}
