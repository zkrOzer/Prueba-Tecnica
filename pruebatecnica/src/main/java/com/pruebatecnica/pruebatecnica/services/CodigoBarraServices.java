package com.pruebatecnica.pruebatecnica.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pruebatecnica.pruebatecnica.models.CodigoBarraModel;
import com.pruebatecnica.pruebatecnica.repositories.CodigoBarraRepository;

@Service
public class CodigoBarraServices {

    @Autowired
    CodigoBarraRepository codigoBarraRepository;

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

    public CodigoBarraModel obtenerByCodigo(String codigo) {
        return codigoBarraRepository.findByCodigo(codigo);
    }

}
