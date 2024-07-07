package com.unla.grupo19.dto;

import java.time.LocalDate;

import com.unla.grupo19.entities.Producto;
import com.unla.grupo19.entities.User;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class InformeCompraDTO {
    private long cantidad;
    private LocalDate fechaCompra;
    private long precioTotal;
    private User cliente;
    private Producto producto;

//    public InformeCompraDTO(Long cantidad, LocalDate fechaCompra, Long precioTotal, User idCliente, Producto idProducto) {
//        this.cantidad = cantidad.intValue(); // Convertimos Long a int
//        this.fechaCompra = fechaCompra;
//        this.precioTotal = precioTotal.intValue(); // Convertimos Long a int
//        this.idCliente = idCliente;
//        this.idProducto = idProducto;
//    }
//
//    // Getters y setters
//
//    public int getCantidad() {
//        return cantidad;
//    }
//
//    public void setCantidad(int cantidad) {
//        this.cantidad = cantidad;
//    }
//
//    public LocalDate getFechaCompra() {
//        return fechaCompra;
//    }
//
//    public void setFechaCompra(LocalDate fechaCompra) {
//        this.fechaCompra = fechaCompra;
//    }
//
//    public int getPrecioTotal() {
//        return precioTotal;
//    }
//
//    public void setPrecioTotal(int precioTotal) {
//        this.precioTotal = precioTotal;
//    }
//
//	public User getIdCliente() {
//		return idCliente;
//	}
//
//	public void setIdCliente(User idCliente) {
//		this.idCliente = idCliente;
//	}
//
//	public Producto getIdProducto() {
//		return idProducto;
//	}
//
//	public void setIdProducto(Producto idProducto) {
//		this.idProducto = idProducto;
//	}

    
}