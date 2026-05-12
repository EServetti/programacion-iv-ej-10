package com.emilio.actividad_10.controller;

import com.emilio.actividad_10.model.Producto;
import com.emilio.actividad_10.repository.ProductoRepository;
import com.emilio.actividad_10.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/producto")
public class ProductoController {
    @Autowired
    private ProductoService productoService;

    @GetMapping
    public Iterable<Producto> findAll()
    {
        return productoService.findAll();
    }

    @PostMapping
    public Producto save(@RequestBody Producto producto)
    {
        return productoService.create(producto);
    }
}
