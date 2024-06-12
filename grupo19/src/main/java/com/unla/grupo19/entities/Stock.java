package com.unla.grupo19.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public abstract class Stock {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected int idStock;

    @ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.MERGE)
    @JoinTable(name = "productos",joinColumns = @JoinColumn(name="id_stock"), inverseJoinColumns = @JoinColumn(name="id_producto") )
    protected List<Producto> productos;

    @Column(name = "cantidad_stock", nullable = false)
    protected int cantidadStock;

    @Column(name = "minimo_stock", nullable = false)
    protected int minimoStock;

}
