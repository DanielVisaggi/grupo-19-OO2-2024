package com.unla.grupo19.services;

import com.unla.grupo19.entities.Producto;

import java.util.List;

public interface IProductoService {
    public Producto findById(int idProducto); // traer producto por ID

    public Producto findByCodigo(String codigo);

    public List<Producto> getAll(); // traer la lista de todos los productos

    public boolean insertOrUpdate(Producto producto); // agrega o modifica un producto

    public boolean remove(int idProducto); // elimina un producto
}
