package com.pruebatecnica.pruebatecnica.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pruebatecnica.pruebatecnica.models.CategoriaModel;
import com.pruebatecnica.pruebatecnica.repositories.CategoriaRepository;

@Service
public class CategoriaServices {

    @Autowired
    CategoriaRepository categoriaRepository;

    public ArrayList<CategoriaModel> obtenerCategorias() {
        return (ArrayList<CategoriaModel>) categoriaRepository.findAll();
    }

    public CategoriaModel guardarCategoria(CategoriaModel categoria) {
        return categoriaRepository.save(categoria);
    }

    public Optional<CategoriaModel> BuscarPorID(Long id) {
        return categoriaRepository.findById(id);
    }

    public boolean eliminar(Long id) {
        try {
            categoriaRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public CategoriaModel obtenerCategoriaByCodigo(String codigo) {
        return categoriaRepository.findOneByCodigo(codigo);
    }

    public CategoriaModel obtenerCategoriaByDescripcion(String descripcion) {
        return categoriaRepository.findOneByDescripcion(descripcion);
    }

    public Optional<CategoriaModel> obtenerCategoriaByCoincidencia(String descripcion) {
        return categoriaRepository.findByDescripcionContaining(descripcion);
    }
}
