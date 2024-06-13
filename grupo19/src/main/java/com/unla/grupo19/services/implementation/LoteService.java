package com.unla.grupo19.services.implementation;

import com.unla.grupo19.entities.Lote;
import com.unla.grupo19.repositories.ILoteRepository;
import com.unla.grupo19.services.ILoteService;
import org.springframework.beans.factory.annotation.Autowired;

public class LoteService implements ILoteService {
    @Autowired
    private ILoteRepository loteRepository;

    @Override
    public Lote saveOrUpdate(Lote lote) {
        return loteRepository.save(lote);
    }
}
