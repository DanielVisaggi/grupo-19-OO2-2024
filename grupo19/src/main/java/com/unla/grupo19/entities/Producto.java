package com.unla.grupo19.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idProducto;

    @Column(name="codigo", unique=true, nullable=false, length=4)
    private String codigo;

    @Column(name="nombre", nullable=false, length=100)
    private String nombre;

    @Column(name="descripcion", nullable=false, length=255)
    private String descripcion;

    @Column(name="costo", nullable=false)
    private int costo;

    @Column(name="precio_de_venta", nullable=false)
    private int precioDeVenta;

    public Producto(String codigo, String nombre, String descripcion, int costo, int precioDeVenta){
        super();
        this.codigo = codigo;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.costo = costo;
        this.precioDeVenta = precioDeVenta;
    }

}
