package com.unla.grupo19.controllers;

import com.unla.grupo19.entities.Lote;
import com.unla.grupo19.entities.Stock;
import com.unla.grupo19.entities.User;
import com.unla.grupo19.helpers.ViewHelperLote;
import com.unla.grupo19.services.implementation.LoteService;
import com.unla.grupo19.services.implementation.StockService;
import com.unla.grupo19.services.implementation.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDate;

@Controller
@RequestMapping("/adm/lote")
public class LoteController {
    @Autowired
    private StockService stockService;

    @Autowired
    private LoteService loteService;

    @Autowired
    private UserService userService;

    @GetMapping("/alta")
    public ModelAndView darDeAltaLotePagina(){
        ModelAndView mav = new ModelAndView(ViewHelperLote.ALTA_LOTE_PAGE);
        User user = userService.findByUsernameQuery(SecurityContextHolder.getContext().getAuthentication().getName());
        mav.addObject("isAdmin", userService.isAdmin(user));
        mav.addObject("stocks", stockService.findAll());
        return mav;
    }

    @PostMapping("/alta/sent")
    public String darDeAltaLote(@ModelAttribute Lote lote, @RequestParam("idStock") int idStock){
        Stock stock = stockService.findByIdStock(idStock);
        stock.setCantidadStock(stock.getCantidadStock() + lote.getCantidadRecibida());
        lote.setFechaRecepcion(LocalDate.now());
        lote.setStock(stock);
        loteService.saveOrUpdate(lote);
        stockService.saveOrUpdate(stock);
        return "redirect:/adm/lote/alta";
    }
}
