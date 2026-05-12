package com.emilio.actividad_10.repository;

import com.emilio.actividad_10.model.Producto;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoRepository extends CrudRepository<Producto,Integer> {
}
