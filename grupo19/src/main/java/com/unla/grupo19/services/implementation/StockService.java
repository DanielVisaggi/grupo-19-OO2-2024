package com.unla.grupo19.services.implementation;

import com.unla.grupo19.entities.Stock;
import com.unla.grupo19.repositories.IStockRepository;
import com.unla.grupo19.services.IStockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public Stock findByIdProducto(int idProducto) {
        return stockRepository.findByIdProducto(idProducto);
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
