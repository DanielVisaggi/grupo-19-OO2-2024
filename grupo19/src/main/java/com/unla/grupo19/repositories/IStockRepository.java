package com.unla.grupo19.repositories;

import com.unla.grupo19.entities.Producto;
import com.unla.grupo19.entities.Stock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Repository
public interface IStockRepository extends JpaRepository<Stock, Serializable> {
    public Stock findByProducto(Producto producto);
}
