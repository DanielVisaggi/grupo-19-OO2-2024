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



    
}