package com.unla.grupo19.repositories;

import com.unla.grupo19.entities.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.io.Serializable;

public interface IProductoRepository extends JpaRepository<Producto, Serializable> {

}
