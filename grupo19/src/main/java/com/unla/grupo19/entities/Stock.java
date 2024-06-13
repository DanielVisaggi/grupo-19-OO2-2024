package com.unla.grupo19.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Stock {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected int idStock;

    @ManyToOne
    @JoinColumn(name = "id_producto")
    protected Producto producto;

    @Column(name = "cantidad_stock", nullable = false)
    protected int cantidadStock;

    @Column(name = "minimo_stock", nullable = false)
    protected int minimoStock;

}
