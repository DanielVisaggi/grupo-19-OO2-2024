package com.unla.grupo19.services;

import com.unla.grupo19.entities.Stock;

public interface IStockService {
    public void saveOrUpdate(Stock stock);
    public Stock findByIdStock(int idStock);
    public Stock findByIdProducto(int idProducto);
    public boolean removeStock(int idStock);
    public boolean removeStock(Stock stock);
}
