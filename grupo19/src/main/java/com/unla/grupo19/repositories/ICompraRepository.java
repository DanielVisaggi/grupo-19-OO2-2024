package com.unla.grupo19.repositories;

import com.unla.grupo19.dto.InformeCompraDTO;
import com.unla.grupo19.entities.Compra;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

@Repository
public interface ICompraRepository extends JpaRepository<Compra,Serializable>{
	
	@Query("SELECT new com.unla.grupo19.dto.InformeCompraDTO(SUM(c.cantidad), MAX(c.fechaCompra), SUM(c.precioFinalVenta), c.cliente, c.producto) " +
	           "FROM Compra c " +
	           "GROUP BY c.cliente, c.producto")
	    List<InformeCompraDTO> traerListadoInforme();

}
