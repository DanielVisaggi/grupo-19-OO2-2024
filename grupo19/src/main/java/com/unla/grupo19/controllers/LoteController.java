package com.unla.grupo19.controllers;

import com.unla.grupo19.helpers.ViewHelperLote;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/lote")
public class LoteController {
    @GetMapping("")
    public String loteIndex(){
        return ViewHelperLote.LOTE_INDEX;
    }
}
