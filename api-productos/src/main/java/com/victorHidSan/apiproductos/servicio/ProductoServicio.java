package com.victorHidSan.apiproductos.servicio;

import com.victorHidSan.apiproductos.model.Producto;
import com.victorHidSan.apiproductos.repositorio.ProductoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoServicio {
    @Autowired
    private ProductoRepositorio repositorio;

    public List<Producto>listarProductos(){
        return repositorio.findAll();
    }

    public void guardarProducto(Producto producto){
        repositorio.save(producto);
    }

    public Producto obtenerProductoPorId(Integer id){
        return repositorio.findById(id).get();
    }

    public void eliminarProducto(Integer id){
        repositorio.deleteById(id);
    }
}
