package com.unla.grupo19.controllers;

import com.unla.grupo19.dto.StockEstadoProductosDTO;
import com.unla.grupo19.entities.Lote;
import com.unla.grupo19.entities.Producto;
import com.unla.grupo19.entities.Stock;
import com.unla.grupo19.entities.User;
import com.unla.grupo19.helpers.ViewHelper;
import com.unla.grupo19.helpers.ViewHelperLote;
import com.unla.grupo19.helpers.ViewHelperProducto;
import com.unla.grupo19.services.implementation.ProductoService;
import com.unla.grupo19.services.implementation.StockService;
import com.unla.grupo19.services.implementation.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/producto")
@RestController
public class ProductoController {

    // Inyecto el servicio de productos
    @Autowired
    private ProductoService service;

    // Inyecto el servicio de stock
    @Autowired
    private StockService stockService;

    @Autowired
    private UserService userService;

    // Manejo la petición GET para obtener un producto por su ID
    @GetMapping("/{id}")
    public String getById(@PathVariable(name="id")int id, Model model) {
        // Busco el producto por ID
        Producto producto = service.findById(id);
        // Agrego el producto al modelo para usarlo en la vista
        model.addAttribute("producto", producto);
        // Retorno la vista del producto
        return "producto/getById.html";
    }

    @GetMapping("/estado")
    public ModelAndView estadoPage(){
        ModelAndView mav = new ModelAndView(ViewHelper.ESTADO_PRODUCTOS_PAGE);
        User user = userService.findByUsernameQuery(SecurityContextHolder.getContext().getAuthentication().getName());
        List<StockEstadoProductosDTO> stocks = stockService.stocksToStockEstadoProductosDTO(stockService.findAll());
        mav.addObject("stocks", stocks);
        mav.addObject("isAdmin", userService.isAdmin(user));
        return mav;
    }

    // Manejo la petición GET para la página de alta de productos
    @GetMapping("/alta")
    public ModelAndView altaProductoPage(){
        // Creo un ModelAndView para la página de alta de productos
        ModelAndView mAV = new ModelAndView(ViewHelperProducto.PRODUCTO_NEW);
        User user = userService.findByUsernameQuery(SecurityContextHolder.getContext().getAuthentication().getName());
        mAV.addObject("isAdmin", userService.isAdmin(user));
        // Retorno el ModelAndView
        return mAV;
    }

    // Manejo la petición GET para listar todos los productos
    @GetMapping("/list")
    public ModelAndView listAllProductos() {
        // Creo un ModelAndView para la lista de productos
        ModelAndView mav = new ModelAndView("producto/listProductos");
        // Obtengo todos los stocks
        List<Stock> stocks = stockService.findAll();
        User user = userService.findByUsernameQuery(SecurityContextHolder.getContext().getAuthentication().getName());
        // Extraigo los productos de los stocks y filtro los productos visibles
        List<Producto> productos = stocks.stream()
                .map(Stock::getProducto)
                .filter(Producto::isVisible) // Filtrar productos visibles
                .distinct()
                .collect(Collectors.toList());
        // Agrego la lista de productos al ModelAndView
        mav.addObject("productos", productos);
        mav.addObject("isAdmin", userService.isAdmin(user));
        // Retorno el ModelAndView
        return mav;
    }

    // Manejo la petición POST para crear un nuevo producto
    @PostMapping("/alta/sent")
    public ModelAndView altaProductoSent(@ModelAttribute Producto producto, @ModelAttribute Stock stock, RedirectAttributes redirectAttributes) {
        // Configuro el producto como visible
        producto.setVisible(true);
        // Creo un ModelAndView para redirigir a la página de alta
        ModelAndView mav = new ModelAndView("redirect:/producto/alta");
        try {
            // Inserto o actualizo el producto
            service.insertOrUpdate(producto);
            // Asigno el producto al stock
            stock.setProducto(service.findByCodigo(producto.getCodigo()));
            // Inserto o actualizo el stock
            stockService.saveOrUpdate(stock);
            // Agrego un mensaje de éxito a los atributos de redirección
            redirectAttributes.addFlashAttribute("successMessage", "Producto creado exitosamente.");
        } catch (Exception e) {
            // Agrego un mensaje de error a los atributos de redirección
            redirectAttributes.addFlashAttribute("errorMessage", "Error al crear el producto.");
        }
        // Retorno el ModelAndView
        return mav;
    }

    // Manejo la petición GET para obtener los datos de un producto por su ID para edición
    @GetMapping("/editar/{id}")
    @ResponseBody
    public Producto editProductoPage(@PathVariable("id") int id) {
        // Retorno el producto encontrado por su ID
        return service.findById(id);
    }

    // Manejo la petición POST para editar un producto
    @PostMapping("/editar")
    public ModelAndView editProducto(@ModelAttribute Producto producto, RedirectAttributes redirectAttributes) {
        // Inserto o actualizo el producto
        service.insertOrUpdate(producto);
        // Creo un ModelAndView para redirigir a la lista de productos
        ModelAndView mav = new ModelAndView("redirect:/producto/list");
        // Agrego un mensaje de éxito a los atributos de redirección
        redirectAttributes.addFlashAttribute("successMessage", "Producto editado exitosamente.");
        // Retorno el ModelAndView
        return mav;
    }

    // Manejo la petición GET para ocultar un producto (borrado lógico)
    @GetMapping("/borrar/{id}")
    public ModelAndView deleteProducto(@PathVariable("id") int id, RedirectAttributes redirectAttributes) {
        // Busco el producto por ID
        Producto producto = service.findById(id);
        // Creo un ModelAndView para redirigir a la lista de productos
        ModelAndView mav = new ModelAndView("redirect:/producto/list");
        if (producto != null) {
            // Configuro el producto como no visible (borrado lógico)
            producto.setVisible(false);
            // Inserto o actualizo el producto
            service.insertOrUpdate(producto);
            // Agrego un mensaje de éxito a los atributos de redirección
            redirectAttributes.addFlashAttribute("successMessage", "Producto ocultado exitosamente.");
        } else {
            // Agrego un mensaje de error a los atributos de redirección
            redirectAttributes.addFlashAttribute("errorMessage", "Error al ocultar el producto.");
        }
        // Retorno el ModelAndView
        return mav;
    }
}
