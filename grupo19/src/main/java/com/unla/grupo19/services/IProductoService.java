package com.unla.grupo19.services;

import com.unla.grupo19.entities.Producto;

import java.util.List;

public interface IProductoService {
    public Producto findById(int idProducto); // traer departamento por ID

    public Producto findByCodigo(String codigo);

    public List<Producto> getAll(); // traer la lista de todos los departamentos

    public boolean insertOrUpdate(Producto producto); // agrega o modifica un departamento

    public boolean remove(int idProducto); // elimina un departamento
}
