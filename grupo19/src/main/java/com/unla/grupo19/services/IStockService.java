package com.unla.grupo19.services;

import com.unla.grupo19.dto.StockEstadoProductosDTO;
import com.unla.grupo19.entities.Producto;
import com.unla.grupo19.entities.Stock;

import java.util.List;

public interface IStockService {
    public void saveOrUpdate(Stock stock);
    public Stock findByIdStock(int idStock);
    public Stock findByProducto(Producto producto);
    public List<Stock> findAll();
    public List<Stock> findStocksWithVisibleProducts();
    public List<StockEstadoProductosDTO> stocksToStockEstadoProductosDTO(List<Stock> stocks);
    public boolean removeStock(int idStock);
    public boolean removeStock(Stock stock);
}
