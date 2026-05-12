package com.emilio.actividad_10.service;

import com.emilio.actividad_10.model.Producto;
import com.emilio.actividad_10.repository.ProductoRepository;
import org.springframework.stereotype.Service;

@Service
public class ProductoService {
    ProductoRepository repo;
    public ProductoService(ProductoRepository repo) {
        this.repo = repo;
    }

    public Iterable<Producto> findAll(){
        return repo.findAll();
    }

    public Producto create(Producto producto){
        return repo.save(producto);
    }
}
