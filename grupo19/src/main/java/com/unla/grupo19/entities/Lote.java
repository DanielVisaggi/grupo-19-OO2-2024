package com.unla.grupo19.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Lote {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idLote;

    @Column(name = "cantidad_recibida", nullable = false)
    private int cantidadRecibida;

    @Column(name = "fecha_recepcion", nullable = false)
    private LocalDate fechaRecepcion;

    @Column(name = "proveedor", nullable = false)
    private String proveedor;

    @Column(name = "precio_de_compra", nullable = false)
    private int precioDeCompra;

    @ManyToOne
    @JoinColumn(name = "id_stock")
    private Stock stock;

    public Lote(int cantidadRecibida, LocalDate fechaRecepcion, String proveedor, int precioDeCompra){
        super();
        this.cantidadRecibida = cantidadRecibida;
        this.fechaRecepcion = fechaRecepcion;
        this.proveedor = proveedor;
        this.precioDeCompra = precioDeCompra;
    }
}
