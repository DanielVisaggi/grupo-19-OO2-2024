package com.unla.grupo19.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idPedido;

    @Column(name = "cantidad", nullable = false)
    private int cantidad;

    @Column(name = "fecha", nullable = false)
    private LocalDate fecha;

    @Column(name = "proveedor", nullable = false)
    private String proveedor;

    @ManyToOne
    @JoinColumn(name = "id_stock")
    private Stock stock;

    public Pedido(int cantidad, LocalDate fecha, String proveedor){
        this.cantidad = cantidad;
        this.fecha = fecha;
        this.proveedor = proveedor;
    }
}
