package com.unla.grupo19.dto;

import com.unla.grupo19.entities.Producto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StockEstadoProductosDTO {
    private Producto producto;
    private int cantidadStock;
    private int minimoStock;
}
