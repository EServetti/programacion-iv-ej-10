package com.emilio.actividad_10.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Producto {
    @Id
    @GeneratedValue
    Long id;

    @Column(nullable=false, unique=true)
    String nombre;

    @Column(nullable=false)
    String descripcion;

    @Column(nullable=false)
    double precio;

    @Column(nullable=false)
    int stock;
}
