package com.pruebatecnica.pruebatecnica.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pruebatecnica.pruebatecnica.models.CodigoBarraModel;
import com.pruebatecnica.pruebatecnica.models.ProductoModel;
import com.pruebatecnica.pruebatecnica.services.CodigoBarraServices;
import com.pruebatecnica.pruebatecnica.services.ProductoServices;

@RestController
@RequestMapping("/codigobarra")
public class CodigoBarraController {

    @Autowired
    CodigoBarraServices codigoBarraServices;
    ProductoServices productoServices;

    @GetMapping()
    public ArrayList<CodigoBarraModel> obtenerTodos() {
        return codigoBarraServices.obtenerCodigoBarras();
    }

    @PostMapping()
    public CodigoBarraModel guardar(CodigoBarraModel codigo) {
        return this.codigoBarraServices.guardarCodigoBarras(codigo);
    }

    @PutMapping()
    public CodigoBarraModel actualizar(CodigoBarraModel codigo) {
        return this.codigoBarraServices.guardarCodigoBarras(codigo);
    }

    @DeleteMapping(path = "/{id}")
    public String eliminarPorId(@PathVariable("id") Long id) {
        boolean ok = this.codigoBarraServices.eliminarCodigoBarras(id);
        if (ok) {
            return "Se elimino " + id;
        } else {
            return "No se pudo eliminar " + id;
        }
    }

    @GetMapping("/codigo")
    public ProductoModel obtenerCategoriaByCodigo(String codigo) {
        return codigoBarraServices.obtenerByCodigo(codigo);
    }


}
