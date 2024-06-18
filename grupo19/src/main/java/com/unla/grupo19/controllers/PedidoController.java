package com.unla.grupo19.controllers;

import com.unla.grupo19.entities.Pedido;
import com.unla.grupo19.entities.Stock;
import com.unla.grupo19.entities.User;
import com.unla.grupo19.entities.Producto;
import com.unla.grupo19.services.implementation.PedidoService;
import com.unla.grupo19.services.implementation.ProductoService;
import com.unla.grupo19.services.implementation.StockService;
import com.unla.grupo19.services.implementation.UserService;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.security.core.context.SecurityContextHolder;

@Controller
@RequestMapping("/adm/pedido")
public class PedidoController {

	@Autowired
	private PedidoService pedidoService;
	
	@Autowired
	private StockService stockService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private ProductoService productoService;
	
	@GetMapping("/alta/{idProducto}")
	public ModelAndView pedidoAprovisionamientoAlta(@PathVariable("idProducto") int idProducto) {
		
		ModelAndView mAV = new ModelAndView("admin/pedido/altaPedido");

		Producto producto = productoService.findById(idProducto);
		Stock stock = stockService.findByProducto(producto);
		
		mAV.addObject("idStock", stock.getIdStock());

		return mAV;
	}
	
	@PostMapping("/alta/solicitada")
	public String pedidoAprovisionamientoSolicitado(@RequestParam("cantidad") int cantidad,  @RequestParam("proveedor") String proveedor, @RequestParam("idStock") int idStock) {
		
		//Obtengo User y Stock
		User user = userService.findByUsernameQuery(SecurityContextHolder.getContext().getAuthentication().getName());
		Stock stock = stockService.findByIdStock(idStock);	
		
		//Creo el Pedido
		Pedido pedido = new Pedido(cantidad, LocalDate.now(), proveedor);
		pedido.setStock(stock);
		pedido.setUser(user);
		pedidoService.saveOrUpdate(pedido);
		
		//Actualizo el stock
		stock.setCantidadStock(stock.getCantidadStock()+pedido.getCantidad());
		stockService.saveOrUpdate(stock);
		
		return "redirect:/producto/estado";
	}
	
}
