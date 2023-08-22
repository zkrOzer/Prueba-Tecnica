package com.pruebatecnica.pruebatecnica.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.pruebatecnica.pruebatecnica.models.CategoriaModel;

@Repository
public interface CategoriaRepository extends JpaRepository<CategoriaModel, Long> {

    @Query(value = "select c from CategoriaModel c where codigo = :codigo")
    CategoriaModel findOneByCodigo(@Param("codigo") String codigo);

    @Query(value = "select c from CategoriaModel c where descripcion = :descripcion")
    CategoriaModel findOneByDescripcion(@Param("descripcion") String descripcion);

    Optional<CategoriaModel> findByDescripcionContaining(String descripcion);

}
