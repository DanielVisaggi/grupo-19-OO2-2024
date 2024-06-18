package com.unla.grupo19.services.implementation;

import com.unla.grupo19.dto.StockEstadoProductosDTO;
import com.unla.grupo19.entities.Producto;
import com.unla.grupo19.entities.Stock;
import com.unla.grupo19.repositories.IStockRepository;
import com.unla.grupo19.services.IStockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StockService implements IStockService {

    @Autowired
    private IStockRepository stockRepository;

    @Override
    public void saveOrUpdate(Stock stock) {
        stockRepository.save(stock);
    }

    @Override
    public Stock findByIdStock(int idStock) {
        return stockRepository.findById(idStock).orElse(null);
    }

    @Override
    public Stock findByProducto(Producto producto) {
        return stockRepository.findByProducto(producto);
    }

    @Override
    public List<Stock> findAll() {
        return stockRepository.findAll();
    }

    @Override
    public List<StockEstadoProductosDTO> stocksToStockEstadoProductosDTO(List<Stock> stocks) {
        List<StockEstadoProductosDTO> newStocks = new ArrayList<>();
        for(Stock stock : stocks)
            newStocks.add(new StockEstadoProductosDTO(stock.getProducto(), stock.getCantidadStock(), stock.getMinimoStock()));
        return newStocks;
    }

    @Override
    public boolean removeStock(int idStock) {
        boolean removed = true;
        try{
            stockRepository.delete(findByIdStock(idStock));
        }catch(Exception e){
            removed = false;
        }
        return removed;
    }

    @Override
    public boolean removeStock(Stock stock) {
        boolean removed = true;
        try{
            stockRepository.delete(stock);
        }catch(Exception e){
            removed = false;
        }
        return removed;
    }
}
