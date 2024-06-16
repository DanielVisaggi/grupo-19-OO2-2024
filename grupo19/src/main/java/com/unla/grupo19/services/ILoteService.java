package com.unla.grupo19.services;

import com.unla.grupo19.entities.Lote;

import java.util.List;

public interface ILoteService {
    public Lote saveOrUpdate(Lote lote);
    public Lote findById(int idLote);
    public List<Lote> findAll();
    public boolean deleteById(Lote lote);
}
