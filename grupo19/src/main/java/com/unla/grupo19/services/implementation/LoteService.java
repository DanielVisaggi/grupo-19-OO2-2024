package com.unla.grupo19.services.implementation;

import com.unla.grupo19.entities.Lote;
import com.unla.grupo19.repositories.ILoteRepository;
import com.unla.grupo19.services.ILoteService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class LoteService implements ILoteService {
    @Autowired
    private ILoteRepository loteRepository;

    @Override
    public Lote saveOrUpdate(Lote lote) {
        return loteRepository.save(lote);
    }

    @Override
    public Lote findById(int idLote) {
        return loteRepository.findByIdStock(idLote);
    }

    @Override
    public List<Lote> findAll() {
        return loteRepository.findAll();
    }

    @Override
    public boolean deleteById(Lote lote) {
        boolean deleted = true;
        try{
            loteRepository.delete(lote);
        }catch(Exception e){
            deleted = false;
        }
        return deleted;
    }
}
