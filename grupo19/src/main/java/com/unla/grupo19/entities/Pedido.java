package com.unla.grupo19.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Pedido extends Stock {

    @Column(name = "cantidad", nullable = false)
    private int cantidad;

    @Column(name = "fecha", nullable = false)
    private LocalDate fecha;

    @Column(name = "proveedor", nullable = false)
    private String proveedor;

    public Pedido(int cantidad, LocalDate fecha, String proveedor){
        super();
        this.cantidad = cantidad;
        this.fecha = fecha;
        this.proveedor = proveedor;
    }
}
