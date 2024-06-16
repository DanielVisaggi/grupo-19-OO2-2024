package com.unla.grupo19.services.implementation;

import com.unla.grupo19.entities.Compra;
import com.unla.grupo19.repositories.ICompraRepository;
import com.unla.grupo19.services.ICompraService;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompraService implements ICompraService {

	@Autowired
	private ICompraRepository compraRepository;
	
	@Override
	public List<Compra> getAll(){
		return compraRepository.findAll();
	};

	@Override
	public Optional<Compra> findById(int id) throws Exception{
		return compraRepository.findById(id);
	};

	@Override
	public Compra insertOrUpdate(Compra compra) {
		return compraRepository.save(compra);
	};

	
}
