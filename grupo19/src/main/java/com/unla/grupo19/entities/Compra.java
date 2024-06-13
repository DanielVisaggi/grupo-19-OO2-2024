package com.unla.grupo19.entities;
import java.time.LocalDate;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Compra {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idCompra;
	
    @ManyToOne
    @JoinColumn(name = "id_producto")
	private Producto producto;
	
	@ManyToOne
	@JoinColumn(name = "id_cliente")
	private User cliente;
	
	@Column(name="cantidad", nullable=false)
	private int cantidad;
	
	@Column(name = "fecha_compra", nullable = false)
	private LocalDate fechaCompra;
	
	public Compra(Producto producto, User cliente, int cantidad, LocalDate fechaCompra) {
		super();
		this.producto = producto;
		this.cliente = cliente;
		this.cantidad = cantidad;
		this.fechaCompra = fechaCompra;
	}
}
