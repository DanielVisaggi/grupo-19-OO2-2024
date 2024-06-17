package com.unla.grupo19.repositories;

import com.unla.grupo19.entities.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Repository
public interface IProductoRepository extends JpaRepository<Producto, Serializable> {
    public Producto findByCodigo(String codigo);
}
