package com.unla.grupo19.services;
import java.util.List;
import java.util.Optional;
import com.unla.grupo19.entities.Compra;

public interface ICompraService {

	public List<Compra> getAll();

	public Optional<Compra> findById(int id) throws Exception;

	public Compra insertOrUpdate(Compra compra);
	
}
