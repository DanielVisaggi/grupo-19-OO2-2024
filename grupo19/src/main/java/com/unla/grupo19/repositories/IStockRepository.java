package com.unla.grupo19.repositories;

import com.unla.grupo19.entities.Producto;
import com.unla.grupo19.entities.Stock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

@Repository
public interface IStockRepository extends JpaRepository<Stock, Serializable> {
    public Stock findByProducto(Producto producto);

    @Query(value="SELECT s FROM Stock s JOIN FETCH s.producto p WHERE p.visible = true")
    public List<Stock> findStocksWithVisibleProducts();
}
