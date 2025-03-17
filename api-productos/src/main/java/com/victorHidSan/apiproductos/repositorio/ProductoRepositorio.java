package com.victorHidSan.apiproductos.repositorio;

import com.victorHidSan.apiproductos.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepositorio extends JpaRepository<Producto, Integer> {

}
