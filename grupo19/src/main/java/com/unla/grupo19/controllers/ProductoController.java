package com.unla.grupo19.controllers;


import com.unla.grupo19.entities.Producto;

import com.unla.grupo19.services.implementation.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/producto")

public class ProductoController {

    @Autowired
    private ProductoService service;

    @GetMapping("/{id}")
    public String getById(@PathVariable(name="id")int id, Model model) {

        Producto producto = service.findById(id);
        model.addAttribute("producto", producto);

        return "producto/getById.html";
    }

}
