package com.unla.grupo19.services.implementation;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unla.grupo19.dto.InformeCompraDTO;

import com.unla.grupo19.repositories.ICompraRepository;
import com.unla.grupo19.services.IInformeService;

@Service
public class InformeService implements IInformeService {
	
	@Autowired
	private ICompraRepository compraRepository ;

	@Override
	public List<InformeCompraDTO> getAll() {
		return compraRepository.traerListadoInforme() ;
	}
	

	

}
