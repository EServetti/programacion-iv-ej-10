package com.emilio.actividad_10.controller;

import com.emilio.actividad_10.model.Fetcher;
import com.emilio.actividad_10.model.LogLevel;
import com.emilio.actividad_10.model.Producto;
import com.emilio.actividad_10.service.ProductoService;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/producto")
public class ProductoController {

    private final ProductoService productoService;
    private final Fetcher fetcher;

    public ProductoController(ProductoService productoService, Fetcher fetcher) {
        this.productoService = productoService;
        this.fetcher = fetcher;
    }

    @GetMapping
    public Iterable<Producto> findAll() {
        return productoService.findAll();
    }

    @PostMapping
    public Producto save(@RequestBody Producto producto) {
        Producto saved = productoService.create(producto);
        try {
            fetcher.logRequest(LogLevel.INFO, "Producto creado: " + saved.getNombre());
        } catch (Exception e) {
            System.err.println("[ProductoController] No se pudo enviar el log al LogHub: " + e.getMessage());
        }
        return saved;
    }

    @PostMapping("/_register-loghub")
    public Map<String, Object> registerInLogHub(@RequestParam String name,
                                                @RequestParam String description,
                                                @RequestParam String email) {
        return fetcher.registerApp(name, description, email);
    }
}