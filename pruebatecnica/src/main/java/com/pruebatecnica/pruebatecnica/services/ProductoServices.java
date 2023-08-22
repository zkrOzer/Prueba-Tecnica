package com.pruebatecnica.pruebatecnica.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pruebatecnica.pruebatecnica.models.ProductoModel;
import com.pruebatecnica.pruebatecnica.repositories.ProductoRepository;

@Service
public class ProductoServices {

    @Autowired
    ProductoRepository productoRepository;

    public ArrayList<ProductoModel> obtenerProductos() {
        return (ArrayList<ProductoModel>) productoRepository.findAll();
    }

    public ProductoModel guardarProducto(ProductoModel producto) {
        return productoRepository.save(producto);
    }

    public Optional<ProductoModel> BuscarPorID(Long id) {
        return productoRepository.findById(id);
    }

    public boolean eliminarProducto(Long id) {
        try {
            productoRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public ProductoModel obtenerByCodigo(String codigo) {
        return productoRepository.findOneByCodigo(codigo);
    }

    public ProductoModel obtenerByDescripcion(String descripcion) {
        return productoRepository.findOneByDescripcion(descripcion);
    }

    public Optional<ProductoModel> obtenerByCoincidencia(String descripcion) {
        return productoRepository.findByDescripcionContaining(descripcion);
    }

    public Optional<ProductoModel> obtenerByParecido(String descripcion) {
        return productoRepository.findOneByCoincidencia(descripcion);
    }
}
