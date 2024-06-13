package com.unla.grupo19.repositories;

import com.unla.grupo19.entities.Lote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Repository
public interface ILoteRepository extends JpaRepository<Lote, Serializable> {
    public Lote findByIdStock(int idStock);
}
