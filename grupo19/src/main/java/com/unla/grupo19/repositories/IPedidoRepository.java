package com.unla.grupo19.repositories;

import com.unla.grupo19.entities.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Repository
public interface IPedidoRepository extends JpaRepository<Pedido,Serializable>{

}
