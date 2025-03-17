package com.victorHidSan.apiproductos.controller;

import com.victorHidSan.apiproductos.model.Producto;
import com.victorHidSan.apiproductos.servicio.ProductoServicio;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ProductoController {

    private final ProductoServicio productoServicio;

    @GetMapping("/productos")
    public List<Producto> listarProductos() {
        return productoServicio.listarProductos();
    }

    @GetMapping("/producto/{id}")
    public ResponseEntity<Producto> obtenerProducto(@PathVariable Integer id) {
        try {
            Producto producto = productoServicio.obtenerProductoPorId(id);
            return ResponseEntity.ok(producto);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/producto")
    public void nuevoProducto(@RequestBody Producto producto) {
        productoServicio.guardarProducto(producto);
    }

    @PutMapping("/producto/{id}")
    public ResponseEntity<?> editarProducto(@RequestBody Producto producto, @PathVariable Integer id) {
        try {
            Producto productoExistente = productoServicio.obtenerProductoPorId(id);
            productoExistente.setNombre(producto.getNombre());
            productoExistente.setPrecio(producto.getPrecio());
            productoServicio.guardarProducto(productoExistente);
            return new ResponseEntity<>(producto, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/producto/{id}")
    public void borrarProducto(@PathVariable Integer id) {
        productoServicio.eliminarProducto(id);
    }
}

