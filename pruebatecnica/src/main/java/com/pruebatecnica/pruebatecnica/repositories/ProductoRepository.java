package com.pruebatecnica.pruebatecnica.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.pruebatecnica.pruebatecnica.models.ProductoModel;

@Repository
public interface ProductoRepository extends JpaRepository<ProductoModel, Long> {

    @Query(value = "select p from ProductoModel p where codigo = :codigo")
    ProductoModel findOneByCodigo(@Param("codigo") String codigo);

    @Query(value = "select p from ProductoModel p where descripcion = :descripcion")
    ProductoModel findOneByDescripcion(@Param("descripcion") String descripcion);

    Optional<ProductoModel> findByDescripcionContaining(String descripcion);

    @Query(value = "select p from ProductoModel p where descripcion like %:descripcion%")
    Optional<ProductoModel> findOneByCoincidencia(@Param("descripcion") String descripcion);
}
