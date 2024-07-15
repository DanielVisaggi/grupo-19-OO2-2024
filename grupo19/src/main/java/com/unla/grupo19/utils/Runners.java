package com.unla.grupo19.utils;

import java.time.LocalDateTime;
import java.util.Arrays;

import com.unla.grupo19.entities.Producto;
import com.unla.grupo19.entities.Stock;
import com.unla.grupo19.repositories.IProductoRepository;
import com.unla.grupo19.repositories.IStockRepository;
import com.unla.grupo19.services.implementation.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import com.unla.grupo19.entities.UserRole;
import com.unla.grupo19.repositories.IUserRepository;
import com.unla.grupo19.repositories.IUserRoleRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Component
public class Runners  implements CommandLineRunner{

    @Autowired
    private final IUserRoleRepository rolRepository;

    @Autowired
    private final IUserRepository userRepository;

    @Autowired
    private final IProductoRepository productoRepository;
    @Autowired
    private final ProductoService productoService;

    @Autowired
    private final IStockRepository stockRepository;

    @Override
    public void run(String... args) throws Exception {
        //Creación de productos y stocks iniciales
        if(productoRepository.count() == 0){
            this.productoRepository.saveAll(
                    Arrays.asList(
                            new Producto("ABCD", "Tarjeta Gráfica", "Una tarjeta gráfica de alto rendimiento con 8GB de memoria GDDR6, ideal para juegos y trabajos gráficos.", 125, 250),
                            new Producto("EFGH", "Procesador", "Un procesador de última generación con 6 núcleos y 12 hilos, perfecto para multitarea y juegos.", 100, 200),
                            new Producto("IJKL", "Memoria RAM", "16GB de Memoria RAM DDR4 3200MHz, ideal para mejorar el rendimiento de tu pc.", 50, 130)
                    )
            );
            this.stockRepository.saveAll(
                    Arrays.asList(
                            new Stock(productoService.findById(1), 14, 10),
                            new Stock(productoService.findById(2), 4, 19),
                            new Stock(productoService.findById(3), 65, 60)
                    )
            );
        }
        // TODO Auto-generated method stub
        if(this.rolRepository.count() == 0) {
            this.rolRepository.saveAll(
                    Arrays.asList(new UserRole(Roles.ROLE_ADMIN, LocalDateTime.now(), LocalDateTime.now()), 
                    		new UserRole(Roles.ROLE_AUDITOR, LocalDateTime.now(), LocalDateTime.now())));
        }
        if(this.userRepository.count()==0) {
            this.userRepository.saveAll(Arrays.asList(new com.unla.grupo19.entities.User("admin", new BCryptPasswordEncoder()
            		.encode("1111"), true, LocalDateTime.now(), LocalDateTime.now(),this.rolRepository.findAll())));
        }
    }

}