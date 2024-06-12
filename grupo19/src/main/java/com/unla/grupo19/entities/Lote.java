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
public class Lote extends Stock {

    @Column(name = "cantidad_recibida", nullable = false)
    private int cantidadRecibida;

    @Column(name = "fecha_recepcion", nullable = false)
    private LocalDate fechaRecepcion;

    @Column(name = "proveedor", nullable = false)
    private String proveedor;

    @Column(name = "precio_de_compra", nullable = false)
    private int precioDeCompra;

    public Lote(int cantidadRecibida, LocalDate fechaRecepcion, String proveedor, int precioDeCompra){
        super();
        this.cantidadRecibida = cantidadRecibida;
        this.fechaRecepcion = fechaRecepcion;
        this.proveedor = proveedor;
        this.precioDeCompra = precioDeCompra;
    }

}
