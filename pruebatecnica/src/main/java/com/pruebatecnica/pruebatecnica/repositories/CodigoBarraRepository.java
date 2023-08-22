package com.pruebatecnica.pruebatecnica.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pruebatecnica.pruebatecnica.models.CodigoBarraModel;

@Repository
public interface CodigoBarraRepository extends JpaRepository<CodigoBarraModel, Long> {
    
    CodigoBarraModel findByCodigo(String codigo);
}
