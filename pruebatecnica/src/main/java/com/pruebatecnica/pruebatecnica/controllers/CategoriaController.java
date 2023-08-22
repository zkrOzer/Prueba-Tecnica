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

import com.pruebatecnica.pruebatecnica.models.CategoriaModel;
import com.pruebatecnica.pruebatecnica.services.CategoriaServices;

@RestController
@RequestMapping("/categoria")
public class CategoriaController {

    @Autowired
    CategoriaServices categoriaServices;

    @GetMapping()
    public ArrayList<CategoriaModel> obtenerTodos() {
        return categoriaServices.obtenerCategorias();
    }

    @PostMapping()
    public CategoriaModel guardar(CategoriaModel categoria) {
        return this.categoriaServices.guardarCategoria(categoria);
    }

    @PutMapping()
    public CategoriaModel actualizar(CategoriaModel categoria) {
        return this.categoriaServices.guardarCategoria(categoria);
    }

    @DeleteMapping(path = "/{id}")
    public String eliminarPorId(@PathVariable("id") Long id) {
        boolean ok = this.categoriaServices.eliminar(id);
        if (ok) {
            return "Se elimino " + id;
        } else {
            return "No se pudo eliminar " + id;
        }
    }

    @GetMapping("/codigo")
    public CategoriaModel obtenerCategoriaByCodigo(String codigo) {
        return categoriaServices.obtenerCategoriaByCodigo(codigo);
    }

    @GetMapping("/descripcion")
    public CategoriaModel obtenerCategoriaByDescripcion(String descripcion) {
        return categoriaServices.obtenerCategoriaByDescripcion(descripcion);
    }

    @GetMapping("/coincidencia")
    public Optional<CategoriaModel> obtenerCategoriaByCoincidencia(String coincidencia) {
        return categoriaServices.obtenerCategoriaByCoincidencia(coincidencia);
    }
}
