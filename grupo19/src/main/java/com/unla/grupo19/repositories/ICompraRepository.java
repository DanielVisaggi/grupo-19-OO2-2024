package com.unla.grupo19.repositories;

import com.unla.grupo19.entities.Compra;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Repository
public interface ICompraRepository extends JpaRepository<Compra,Serializable>{

}
