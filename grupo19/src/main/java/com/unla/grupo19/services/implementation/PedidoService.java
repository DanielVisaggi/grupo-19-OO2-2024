package com.unla.grupo19.services.implementation;

import com.unla.grupo19.entities.Pedido;
import com.unla.grupo19.repositories.IPedidoRepository;
import com.unla.grupo19.services.IPedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PedidoService implements IPedidoService{

	@Autowired
	private IPedidoRepository pedidoRepository;
	
	@Override
	public void saveOrUpdate(Pedido pedido) {
		pedidoRepository.save(pedido);
	}
}
