package com.pruebatecnica.pruebatecnica.controllers;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pruebatecnica.pruebatecnica.models.ProductoModel;
import com.pruebatecnica.pruebatecnica.services.ProductoServices;

@RestController
@RequestMapping("/producto")
public class ProductoController {

    @Autowired
    ProductoServices productoServices;

    @GetMapping()
    public ArrayList<ProductoModel> obtenerTodos() {
        return productoServices.obtenerProductos();
    }

    @PostMapping()
    public ProductoModel guardar(ProductoModel producto) {
        return this.productoServices.guardarProducto(producto);
    }

    @PutMapping()
    public ProductoModel actualizar(ProductoModel producto) {
        return this.productoServices.guardarProducto(producto);
    }

    @DeleteMapping(path = "/{id}")
    public String eliminarPorId(@PathVariable("id") Long id) {
        boolean ok = this.productoServices.eliminarProducto(id);
        if (ok) {
            return "Se elimino " + id;
        } else {
            return "No se pudo eliminar " + id;
        }
    }

    @GetMapping("/codigo")
    public ProductoModel obtenerCategoriaByCodigo(String codigo) {
        return productoServices.obtenerByCodigo(codigo);
    }

    @GetMapping("/descripcion")
    public ProductoModel obtenerByDescripcion(String descripcion) {
        return productoServices.obtenerByDescripcion(descripcion);
    }

    @GetMapping("/coincidencia")
    public Optional<ProductoModel> obtenerByCoincidencia(String coincidencia) {
        return productoServices.obtenerByCoincidencia(coincidencia);
    }

    @GetMapping("/parecido")
    public Optional<ProductoModel> obtenerByParecido(String parecido) {
        return productoServices.obtenerByParecido(parecido);
    }
}
