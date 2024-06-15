package com.unla.grupo19.services.implementation;

import com.unla.grupo19.entities.Producto;
import com.unla.grupo19.repositories.IProductoRepository;
import com.unla.grupo19.services.IProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoService implements IProductoService {

    @Autowired
    private IProductoRepository repository;
    private com.unla.grupo19.entities.Producto Producto;

    @Override
    public Producto findById(int idProducto) {
        return repository.findById(idProducto).orElse(null);
    }


    @Override
    public List<Producto> getAll() {
        return repository.findAll();
    }

    @Override
    public boolean insertOrUpdate(Producto producto) {
        return repository.save(Producto) != null? true : false;
    }

    @Override
    public boolean remove(int idProducto) {
        try {
            repository.deleteById(idProducto);
            return true;
        } catch(Exception e) {
            return false;
        }

    }
}
