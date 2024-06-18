package com.unla.grupo19.controllers;

import java.time.LocalDate;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.unla.grupo19.entities.Stock;
import com.unla.grupo19.entities.User;
import com.unla.grupo19.entities.Compra;
import com.unla.grupo19.entities.Producto;
import com.unla.grupo19.helpers.ViewHelper;
import com.unla.grupo19.services.implementation.ProductoService;
import com.unla.grupo19.services.implementation.CompraService;
import com.unla.grupo19.services.implementation.UserService;
import com.unla.grupo19.services.implementation.StockService;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class CompraController {

	@Autowired
	private ProductoService productoService;

	@Autowired
	private UserService userService;

	@Autowired
	private CompraService compraService;

	@Autowired
	private StockService stockService;

	@GetMapping("/comprarProducto")
	public ModelAndView comprarProducto() {
		ModelAndView mAV = new ModelAndView(ViewHelper.COMPRA_PAGE);
		mAV.addObject("productos", productoService.getAll());
		return mAV;
	}

	@PostMapping("/comprar")
	public String comprarProducto(@RequestParam("idProducto") int idProducto, @RequestParam("cantidad") int cantidad,
								  Model model) {

		//Obtengo el producto.
		Producto producto = productoService.findById(idProducto);

		//Obtengo el usuario.
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String username = authentication.getName();
		User user = userService.findByUsernameQuery(username);

		//Obtengo el stock, verifico y lo actualizo
		Stock stock = stockService.findByProducto(producto);

		if(stock.getCantidadStock() < cantidad) {
			model.addAttribute("error", "Lo sentimos, no tenemos stock suficiente");
			model.addAttribute("productos", productoService.getAll());
			return ViewHelper.COMPRA_PAGE;
		}

		stock.setCantidadStock(stock.getCantidadStock()-cantidad);
		stockService.saveOrUpdate(stock);

		//Creo la compra y la guardo
		Compra compra = new Compra(producto, user, cantidad, LocalDate.now(), cantidad * producto.getPrecioDeVenta());
		compraService.insertOrUpdate(compra);

		model.addAttribute("success", "Compra exitosa!");
		model.addAttribute("productos", productoService.getAll());

		return ViewHelper.COMPRA_PAGE;
	}

}
