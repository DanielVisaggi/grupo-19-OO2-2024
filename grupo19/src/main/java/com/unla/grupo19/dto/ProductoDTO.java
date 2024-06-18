package com.unla.grupo19.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor
public class ProductoDTO {

	private int idProducto;
	
	private String nombre;
	
	private String descripcion;
	
	private int precioDeVenta;
	
	public ProductoDTO(int idProducto, String nombre, String descripcion, int precioDeVenta) {
		this.setIdProducto(idProducto);
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.precioDeVenta = precioDeVenta;
	}
	
}