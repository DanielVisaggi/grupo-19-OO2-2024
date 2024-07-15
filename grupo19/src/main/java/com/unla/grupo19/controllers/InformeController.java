package com.unla.grupo19.controllers;


import java.io.FileOutputStream;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.itextpdf.text.Document;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.unla.grupo19.dto.InformeCompraDTO;
import com.unla.grupo19.entities.User;
import com.unla.grupo19.helpers.ViewHelper;

import com.unla.grupo19.services.implementation.InformeService;
import com.unla.grupo19.services.implementation.UserService;

@Controller
@RequestMapping("/informe")
public class InformeController {
	
	@Autowired
	private InformeService informeService;
	
	@Autowired
	private UserService userService;
	
	@GetMapping("")
	public String listarInforme(Model model){
		User user=userService.findByUsernameQuery("admin");
		model.addAttribute("isAdmin", userService.isAdmin(user));
		model.addAttribute("informes", informeService.getAll());
		return  ViewHelper.IFORME_COMPRA;
		
	}
	
	@GetMapping("/generarPDF")
	public String generarReporte(){
		List<InformeCompraDTO> compras = informeService.getAll();		
		Document document = new Document(); //clases q utilizan la dependecia itext5
		
		try {
			String ruta = System.getProperty(("user.home"));
			PdfWriter.getInstance(document, new FileOutputStream(ruta + "/Desktop/Reporte_Compras.pdf"));
			
			
            document.open();
			PdfPTable tabla = new PdfPTable(5);
			tabla.addCell("Cliente");
			tabla.addCell("Producto");
			tabla.addCell("Fecha Compra");
			tabla.addCell("Cantidad");
			tabla.addCell("Precio Total");
			

		
			if(!compras.isEmpty()) {
				for (InformeCompraDTO compra : compras) {
					
					tabla.addCell(String.valueOf( compra.getCliente().getUsername() ));
					tabla.addCell(String.valueOf( compra.getProducto().getNombre() ));
					tabla.addCell(String.valueOf( compra.getFechaCompra().toString() ));
					tabla.addCell(String.valueOf( compra.getCantidad() ));
					tabla.addCell(String.valueOf( compra.getPrecioTotal() ));
				}
				document.add(tabla);			
			}
			else {
				throw new Exception("La BD no tiene compras cargadas");
			}
			
		}catch(Exception e) {
			System.out.println(e.getMessage());;
		}
		finally {
			document.close();
		}
		
		return  ViewHelper.IFORME_COMPRA;
	}

}
