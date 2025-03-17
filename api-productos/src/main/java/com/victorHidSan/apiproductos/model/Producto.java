package com.victorHidSan.apiproductos.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GeneratorType;

@Entity
@Data
@NoArgsConstructor @AllArgsConstructor
@Table(name="productos")
public class Producto {
    @Id
    @GeneratedValue
    private Integer id;
    private String nombre;
    private float precio;
}
