package com.pruebatecnica.pruebatecnica.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pruebatecnica.pruebatecnica.models.CodigoBarraModel;
import com.pruebatecnica.pruebatecnica.models.ProductoModel;
import com.pruebatecnica.pruebatecnica.repositories.CodigoBarraRepository;
import com.pruebatecnica.pruebatecnica.repositories.ProductoRepository;

@Service
public class CodigoBarraServices {

    @Autowired
    CodigoBarraRepository codigoBarraRepository;

    @Autowired
    ProductoRepository productoRepository;

    public ArrayList<CodigoBarraModel> obtenerCodigoBarras() {
        return (ArrayList<CodigoBarraModel>) codigoBarraRepository.findAll();
    }

    public CodigoBarraModel guardarCodigoBarras(CodigoBarraModel codigo) {
        return codigoBarraRepository.save(codigo);
    }

    public Optional<CodigoBarraModel> BuscarPorID(Long id) {
        return codigoBarraRepository.findById(id);
    }

    public boolean eliminarCodigoBarras(Long id) {
        try {
            codigoBarraRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public ProductoModel obtenerByCodigo(String codigo) {
        ArrayList<ProductoModel> todos = (ArrayList<ProductoModel>) productoRepository.findAll();
        Optional<ProductoModel> productoEncontrado = todos.stream()
                .filter(d -> d.getCodigoBarraModel().getCodigo().equals(codigo))
                .findFirst();

        return productoEncontrado.orElse(null);
    }

}
