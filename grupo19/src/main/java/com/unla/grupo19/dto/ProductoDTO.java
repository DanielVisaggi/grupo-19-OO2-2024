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
	
	private boolean visible;
	
	public ProductoDTO(int idProducto, String nombre, String descripcion, int precioDeVenta, boolean visible) {
		this.setIdProducto(idProducto);
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.precioDeVenta = precioDeVenta;
		this.visible = visible;
	}
	
}